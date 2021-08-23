package com.sujith.postgresdemo.repository;

import com.sujith.postgresdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sujith on 23-08-2021
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
