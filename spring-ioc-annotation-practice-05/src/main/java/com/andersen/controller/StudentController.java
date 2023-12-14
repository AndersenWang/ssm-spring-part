package com.andersen.controller;

import com.andersen.pojo.Student;
import com.andersen.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    public void findAll() {
        List<Student> all = studentService.findAll();
        System.out.println("all = " + all);
    }
}
