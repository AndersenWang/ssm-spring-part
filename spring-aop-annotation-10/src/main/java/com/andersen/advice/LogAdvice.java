package com.andersen.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 增强类内部存储增强代码
 *
 * 1.定义方法存储增强代码
 * 2.使用注解配置 指定插入目标方法的位置
 *      前置  @Before
 *      后置  @AfterReturning
 *      异常  @AfterThrowing
 *      最后  @After
 *      环绕  @Around
 *
 *      try {
 *          前置
 *          目标方法执行
 *          后置
 *      } catch() {
 *          异常
 *      } finally {
 *          最后
 *      }
 * 3.配置切点表达式 [选中插入的方法  切点]
 * 4.补全注解
 *      加入ioc容器 @Component
 *      配置切面 @Aspect = 切点 + 增强
 * 5.开启aspect注解的支持
 */

@Component
@Aspect
@Order(20)
public class LogAdvice {

    @Before("com.andersen.pointcut.PointCut.pc()")
    public void start() {
        System.out.println("start");
    }

    @After("com.andersen.pointcut.PointCut.pc()\"")
    public void after() {
        System.out.println("end");
    }

    @AfterThrowing("com.andersen.pointcut.PointCut.pc()\"")
    public void error() {
        System.out.println("error");
    }

}
