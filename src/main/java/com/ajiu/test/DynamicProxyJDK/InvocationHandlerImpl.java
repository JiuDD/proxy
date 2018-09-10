package com.ajiu.test.DynamicProxyJDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * description: InvocationHandler接口的实现类
 *      动态代理类的要素：
 *      1、实现java.lang.reflect.InvocationHandler接口，重写invoke()方法
 *      2、增强逻辑写在invoke()方法里
 * @author: JiuDongDong
 * date: 2018/8/15.
 */
public class InvocationHandlerImpl implements InvocationHandler {
    private Object realObject;// 引入目标类

    public InvocationHandlerImpl(Object realObject) {
        this.realObject = realObject;
    }

    // 增强逻辑写在invoke()方法里
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理扩展逻辑
        System.out.println("代理类做的前增强");// 前增强
        Object result = method.invoke(realObject, args);
        System.out.println("代理类做的后增强");
        return result;
    }
}
