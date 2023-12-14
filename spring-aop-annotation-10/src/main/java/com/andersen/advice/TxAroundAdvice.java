package com.andersen.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class TxAroundAdvice {

    /**
     * @param joinPoint 目标方法（获取方法信息，且多一个执行方法）
     * @return 目标方法的返回值
     */
    @Around("com.andersen.pointcut.PointCut.pc()")
    public Object transaction(ProceedingJoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();
        Object result = null;
        try {
            // 增强代码 -> before
            System.out.println("begin");
            result = joinPoint.proceed(args);
            System.out.println("end");
        } catch (Throwable e) {
            System.out.println("rollback");
            throw new RuntimeException(e);
        }

        return result;
    }
}
