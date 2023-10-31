package com.wanfeng.divSpring.proxy.poxy1;

public class VehicleProxy implements Vehicle{
    private Vehicle vehicle;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void run() {
        System.out.println("开始运行");
        vehicle.run();
        System.out.println("运行结束");
    }
}
