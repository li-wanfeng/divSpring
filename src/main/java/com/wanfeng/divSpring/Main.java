package com.wanfeng.divSpring;

import com.wanfeng.divSpring.proxy.poxy1.Car;
import com.wanfeng.divSpring.proxy.poxy1.Ship;
import com.wanfeng.divSpring.proxy.poxy1.Vehicle;
import com.wanfeng.divSpring.proxy.poxy1.VehicleProxyProvider;
import com.wanfeng.divSpring.proxy.poxy2.Compute;
import com.wanfeng.divSpring.proxy.poxy2.ComputeProxyProvider;
import com.wanfeng.divSpring.proxy.poxy2.Computed;

public class Main {
    public static void main(String[] args) {
////        VehicleProxy vehicleProxy = new VehicleProxy();
////        vehicleProxy.setVehicle(new Car());
////        vehicleProxy.run();
////        vehicleProxy.setVehicle(new Ship());
////        vehicleProxy.run();
        VehicleProxyProvider vehicleProxyProvider = new VehicleProxyProvider();
//        Vehicle proxy = vehicleProxyProvider.getProxy(new Car());
//        Vehicle proxy1 = vehicleProxyProvider.getProxy(new Ship());
//        proxy.run();
//        proxy1.run();

        ComputeProxyProvider computeProxyProvider = new ComputeProxyProvider();
        Compute proxy = computeProxyProvider.getProxy(new Computed());
        proxy.getSub(2,1);
        System.out.println("=============");
        proxy.getSum(2,1);
    }
}