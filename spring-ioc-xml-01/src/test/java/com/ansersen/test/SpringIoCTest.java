package com.ansersen.test;

import com.andersen.ioc_03.HappyComponent;
import com.andersen.ioc_04.JavaBean2;
import com.andersen.ioc_05.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {

//  创建容器
    public void creatIoC() {
        // way1
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        // way2
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
        applicationContext1.setConfigLocation("spring-03.xml");
        applicationContext1.refresh();
    }

    @Test
    public void getBeanFromIoC() {
        // 创建ioc对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        // 读取ioc容器的组件
        // way1
        HappyComponent happyComponent = (HappyComponent) applicationContext.getBean("happyComponent");

        // way2
        HappyComponent happyComponent1 = applicationContext.getBean("happyComponent", HappyComponent.class);

        // way3
        HappyComponent happyComponent2 = applicationContext.getBean(HappyComponent.class);

        happyComponent2.doWork();

        System.out.println(happyComponent == happyComponent1);
        System.out.println(happyComponent1 == happyComponent2);

    }

    @Test
    public void test_04() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");

        JavaBean2 bean = applicationContext.getBean(JavaBean2.class);
        JavaBean2 bean2 = applicationContext.getBean(JavaBean2.class);
        System.out.println(bean == bean2);

        applicationContext.close();
    }

    @Test
    public void test_05() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-05.xml");

        JavaBean javaBean = applicationContext.getBean("javaBean", JavaBean.class);
        System.out.println("javaBean = " + javaBean);

        Object bean = applicationContext.getBean("&javaBean");
        System.out.println("bean = " + bean);

        applicationContext.close();
    }

}
