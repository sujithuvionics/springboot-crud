package com.sujith.postgresdemo.controller;

import com.sujith.postgresdemo.converter.StudentRequestToStudentConverter;
import com.sujith.postgresdemo.converter.StudentToStudentResponseConverter;
import com.sujith.postgresdemo.model.Student;
import com.sujith.postgresdemo.request.StudentRequest;
import com.sujith.postgresdemo.response.StudentResponse;
import com.sujith.postgresdemo.service.StudetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

/**
 * Created by sujith on 23-08-2021
 */
@RequiredArgsConstructor
@RequestMapping("api/v1/students")
@RestController
public class StudentController {

    private final StudetService studetService;

    private final StudentRequestToStudentConverter studentRequestToStudentConverter;

    private final StudentToStudentResponseConverter studentToStudentResponseConverter;

    @PostMapping
    public ResponseEntity<String> saveStudent(@RequestBody StudentRequest studentRequest) {
        Student student = studentRequestToStudentConverter.convert(studentRequest);
        studetService.saveStudent(student);
        return status(CREATED).body("Student created");
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable Long id) {
        Student student = studetService.getStudent(id);
        StudentResponse studentResponse = studentToStudentResponseConverter.convert(student);
        return ok(studentResponse);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        studetService.deleteStudent(id);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getStudents() {
        List<Student> students = studetService.getStudents();
        List<StudentResponse> studentResponses = studentToStudentResponseConverter.convert(students);
        return ok(studentResponses);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        Student student = studentRequestToStudentConverter.convert(studentRequest);
        student.setId(id);
        studetService.updateStudent(student);
        return ok("Student updated");
    }

}
