package com.andersen.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.andersen")
@EnableAspectJAutoProxy  // 开启aspect的注解支持
public class JavaConfig {
}
