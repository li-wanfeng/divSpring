package com.wanfeng.divSpring.proxy.poxy2;

public class Computed implements Compute{
    @Override
    public int getSub(int num1, int num2) {
        return num1-num2;
    }

    @Override
    public int getSum(int num1, int num2) {
        return num1+num2;
    }
}
