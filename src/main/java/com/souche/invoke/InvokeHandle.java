package com.souche.invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/***
 *@author fanmiao
 *@date 2020/4/2 3:43 下午 
 */
public class InvokeHandle implements InvocationHandler {
    private Object object;

    public Object getInvokeHandle(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass());
        for (Object arg : args) {
            System.out.println(arg);
        }
        System.out.println("start");
        Object invoke = method.invoke(object, args);
        System.out.println("end");
        return invoke;
    }
}
