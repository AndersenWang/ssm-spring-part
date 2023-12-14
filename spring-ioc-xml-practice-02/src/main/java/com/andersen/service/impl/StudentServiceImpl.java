package com.andersen.service.impl;

import com.andersen.dao.StudentDao;
import com.andersen.pojo.Student;
import com.andersen.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        System.out.println("studentService:" + studentList);
        return studentList;
    }
}
