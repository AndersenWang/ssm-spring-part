package com.andersen.test;

import com.andersen.config.JavaConfig;
import com.andersen.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAopTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void test() {
        int add = calculator.add(1, 1);
        System.out.println("add = " + add);
    }

}
