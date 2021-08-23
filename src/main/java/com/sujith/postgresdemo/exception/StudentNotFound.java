package com.sujith.postgresdemo.exception;

/**
 * Created by sujith on 23-08-2021
 */
public class StudentNotFound extends RuntimeException {

    public StudentNotFound(String message) {
        super(message);
    }
}
