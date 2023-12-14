package com.andersen.test;

import com.andersen.components.A;
import com.andersen.components.B;
import com.andersen.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfig.class)
public class SpringIoCTest {

    @Autowired
    private A a;

    @Autowired
    private B b;

    @Test
    public void test() {
        System.out.println(a);
    }
}
