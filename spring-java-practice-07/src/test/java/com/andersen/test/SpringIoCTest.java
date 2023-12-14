package com.andersen.test;

import com.andersen.config.JavaConfig;
import com.andersen.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIoCTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);

        StudentController controller = applicationContext.getBean(StudentController.class);

        controller.findAll();
    }
}
