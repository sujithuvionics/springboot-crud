package com.sujith.postgresdemo.converter;

import com.sujith.postgresdemo.model.Student;
import com.sujith.postgresdemo.request.StudentRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by sujith on 23-08-2021
 */
@Component
public class StudentRequestToStudentConverter implements Converter<StudentRequest, Student> {

    @Override
    public Student convert(StudentRequest source) {
        Student student = new Student();
        student.setName(source.getName());
        student.setAge(source.getAge());
        return student;
    }
}
