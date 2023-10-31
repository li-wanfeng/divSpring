package com.wanfeng.divSpring.proxy.poxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class VehicleProxyProvider {
    /**
     * ClassLoader loader:类加载器
     * Class<?>[] interfaces：要代理的对象的接口信息
     * InvocationHandler：调用处理器  有invock方法
     * @return
     */
    public <T> Vehicle getProxy(T t){
        Object o = Proxy.newProxyInstance(t.getClass().getClassLoader(),
                t.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * @param proxy 代理对象
                     * @param method 通过代理对象调用方法时的哪个方法
                     *               这里解释一下。该方法返回代理对象，代理对象调用原对象的方法就是method参数
                     *               因为这个方法是需要让原对象去进行调用的
                     *               所以需要通过反射调用方法的机制去调用
                     * @param args 参数
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始运行");
                        Object invoke = method.invoke(t, args);
                        System.out.println("运行结束");
                        return invoke;
                    }
                });
        return (Vehicle) o;
    }
}
