package com.andersen.service;

import com.andersen.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class StudentService {
    
    @Autowired
    private StudentDao studentDao;

    @Transactional(readOnly = false, rollbackFor = Exception.class,
            noRollbackFor = FileNotFoundException.class, isolation = Isolation.READ_COMMITTED)
    public void changeInfo() throws FileNotFoundException {
        studentDao.updateAgeById(99,1);
        // int i = 1/0;
        System.out.println("-----------");
        new FileInputStream("xxxx");
        studentDao.updateNameById("test3",1);
    }

    @Transactional(readOnly = true)
    public void getStudentInfo() {

    }

    /**
     * 声明两个独立修改数据库的事务业务方法
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeAge(){
        studentDao.updateAgeById(998,1);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeName(){
        studentDao.updateNameById("haha",1);
        int i = 1 / 0;
    }

}
