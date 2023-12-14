package com.andersen.dao;

import com.andersen.pojo.Student;

import java.util.List;

public interface StudentDao {

    List<Student> queryAll();
}
