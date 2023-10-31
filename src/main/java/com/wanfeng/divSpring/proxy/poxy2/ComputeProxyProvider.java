package com.wanfeng.divSpring.proxy.poxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ComputeProxyProvider {

    public <T> Compute getProxy(T t){
        Object o = Proxy.newProxyInstance(
                t.getClass().getClassLoader(),
                t.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try {
                            System.out.println("方法执行日志开始-方法名" + method.getName() + "参数:[" + args[0]+","+args[1]+"]");
                            Object invoke = method.invoke(t, args);
                            System.out.println("方法内部打印结果：result：" + invoke);
                            System.out.println("方法执行正常结束-日志-方法名-" + method.getName() + "-结果result：" + invoke);
                            System.out.println("方法最终结束-日志-方法名-" + method.getName());
                            return invoke;
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                            System.out.println("");
                            throw new RuntimeException(e);
                        } finally {
                            System.out.println("");
                        }
                    }
                }
        );
        return (Compute) o;
    }
}
