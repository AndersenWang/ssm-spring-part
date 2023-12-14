package com.andersen.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * TODO:增强方法中互殴去目标方法信息
 * 1.全部增强发发中，获取目标方法的信息（所属类的信息，访问修饰符，方法名，参数...）
 *      (JoinPoint joinPoint)
 * 2.返回的结果 - @AfterReturning
 *      (Object result)
 *      @AfterReturning(value = "execution(* com..impl.*.*(..))", returning = "result")
 * 3.异常的信息 - @AfterThrowing
 *      (Throwable throwable)
 *      @AfterThrowing(value = "execution(* com..impl.*.*(..))", throwing = "throwable")
 *
 * TODO：切点表达式
 *      固定语法 execution(1 2 3.4.5(6))
 *      1.访问修饰符
 *          public / private
 *      2.方法的返回参数类型
 *          String int void
 *          如果不考虑访问修饰符和返回值！这两位整合成一起写
 *          如果要是不考虑，必须两个都不考虑！不能出现＊String
 *      3.包的位置
 *          具体包: com.andersen.service.impl
 *          单层模糊: com.andersen.service.*   *:单层模糊
 *          多层模糊: com..impl   ...任意层的模糊
 *          细节: ..不能开头
 *          找所有impl包:com..impl 不能写..impl 写成：*..impl
 *      4．类的名称
 *          具体: CalculatorPureImpl
 *          模糊: *
 *          部分模糊: *Impl
 *      5．方法名 语法和类名一致
 *      6．(6)形参数列表
 *          没有参数: ()
 *          有具体参数：(String)  (String, int)
 *          模糊参数：(..)有没有参数都可以，有多个也可以！
 *          部分模糊：(String..)String 后面有没有无所谓
 *          (..int) 最后一个参数是int
 *          (String..int)
 *
 */

//@Component
//@Aspect
public class MyAdvice {

    @Before("com.andersen.pointcut.PointCut.myPc()")
    public void before(JoinPoint joinPoint) {

        // 1.获取方法所属类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        // 2.获取方法类型
        int modifiers = joinPoint.getSignature().getModifiers();
        String mod = Modifier.toString(modifiers);
        // 3.获取方法名称
        joinPoint.getSignature().getName();
        // 4.获取参数列表
        Object[] args = joinPoint.getArgs();
    }

    @AfterReturning(value = "com.andersen.pointcut.PointCut.myPc()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

    }

    @After("com.andersen.pointcut.PointCut.myPc()")
    public void after(JoinPoint joinPoint) {

    }

    @AfterThrowing(value = "com.andersen.pointcut.PointCut.myPc()", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {

    }

}
