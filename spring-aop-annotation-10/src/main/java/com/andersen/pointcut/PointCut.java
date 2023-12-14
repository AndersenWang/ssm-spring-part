package com.andersen.pointcut;


import org.aspectj.lang.annotation.Pointcut;

public class PointCut {

    @Pointcut("execution(* com.andersen.service.impl.*.*(..))")
    public void pc() {}

    @Pointcut("execution(* com..impl.*.*(..))")
    public void myPc() {}

}
