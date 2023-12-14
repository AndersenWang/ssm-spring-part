package com.andersen.service;

import com.andersen.pojo.Student;

import java.util.List;

public interface StudentService {

    /**
     * 查询所有学员数据业务
     * @return List
     */
    List<Student> findAll();
}
