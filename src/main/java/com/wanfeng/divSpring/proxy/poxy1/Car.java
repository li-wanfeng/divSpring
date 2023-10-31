package com.wanfeng.divSpring.proxy.poxy1;

public class Car implements Vehicle {

    @Override
    public void run() {
        System.out.println("car running");
    }
}
