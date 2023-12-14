package com.andersen.test;

import com.andersen.config.JavaConfiguration;
import com.andersen.config.JavaConfigurationA;
import com.andersen.config.JavaConfigurationB;
import com.andersen.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIocTest {

    @Test
    public void test() {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        StudentController bean = applicationContext.getBean(StudentController.class);

        System.out.println("bean = " + bean);

    }

    @Test
    public void test_04() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfigurationA.class);
    }
}
