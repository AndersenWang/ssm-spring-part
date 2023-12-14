package com.andersen;

import com.andersen.statics.StaticProxyCalculator;

public class UseAop {

    public static void main(String[] args) {
        Calculator target = new CalculatorPureImpl();

        Calculator proxy = new StaticProxyCalculator(target);

        int add = proxy.add(1, 1);
        System.out.println("add = " + add);
    }
}
