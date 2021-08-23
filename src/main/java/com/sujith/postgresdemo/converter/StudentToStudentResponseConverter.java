package com.sujith.postgresdemo.converter;

import com.sujith.postgresdemo.model.Student;
import com.sujith.postgresdemo.response.StudentResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sujith on 23-08-2021
 */
@Component
public class StudentToStudentResponseConverter implements Converter<Student, StudentResponse> {
    @Override
    public StudentResponse convert(Student source) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setAge(source.getAge());
        studentResponse.setName(source.getName());
        studentResponse.setId(source.getId());
        return studentResponse;
    }

    public List<StudentResponse> convert(List<Student> students) {
        return students.stream().map(this::convert).collect(Collectors.toList());
    }

}
