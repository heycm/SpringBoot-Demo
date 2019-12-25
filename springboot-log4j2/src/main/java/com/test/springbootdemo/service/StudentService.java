package com.test.springbootdemo.service;


import com.test.springbootdemo.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findByName(String... name);
}
