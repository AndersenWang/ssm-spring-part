package com.andersen.service;

import com.andersen.dao.StudentDao;
import com.andersen.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    // 接口 类型和 实现类 的 instanceof 返回值相同，可以通过 接口 拿
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        return studentList;
    }
}
