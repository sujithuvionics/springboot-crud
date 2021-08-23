package com.sujith.postgresdemo.service;

import com.sujith.postgresdemo.exception.StudentNotFound;
import com.sujith.postgresdemo.model.Student;
import com.sujith.postgresdemo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sujith on 23-08-2021
 */
@RequiredArgsConstructor
@Service
public class StudetService {

    private final StudentRepository studentRepository;

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFound("Requested student not found"));
    }

    public void deleteStudent(Long id) {
        Student student = getStudent(id);
        studentRepository.delete(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void updateStudent(Student student) {
        getStudent(student.getId());
        studentRepository.save(student);
    }
}
