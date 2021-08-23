package com.sujith.postgresdemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by sujith on 23-08-2021
 */
@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private Integer age;

}
