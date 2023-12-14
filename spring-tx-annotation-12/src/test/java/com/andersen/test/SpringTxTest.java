package com.andersen.test;

import com.andersen.config.JavaConfig;
import com.andersen.service.StudentService;
import com.andersen.service.TopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.FileNotFoundException;

@SpringJUnitConfig(JavaConfig.class)
public class SpringTxTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TopService topService;

    @Test
    public void test() throws FileNotFoundException {
        topService.topService();
    }

}
