package com.andersen.ioc_04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JavaBean {

    // 方案一：直接赋值
    public String name = "Andersen";

    // 方案二：注解
    @Value("18")
    public int age;

    @Value("${jdbc.username:admin}")
    public String username;

    @Value("${jdbc.password}")
    public String password;

    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
