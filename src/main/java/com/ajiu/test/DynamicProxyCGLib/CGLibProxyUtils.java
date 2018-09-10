package com.ajiu.test.DynamicProxyCGLib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * description: 这个类用来生成被代理类的动态代理类，需要做2个事情才能实现代理功能：
 *      1、实现net.sf.cglib.proxy.MethodInterceptor方法拦截接口
 *      2、重写MethodInterceptor的intercept()拦截方法，在里面定义增强逻辑
 *      3、对外提供获取代理对象的方法
 * @author: JiuDongDong
 * date: 2018/8/17.
 */
public class CGLibProxyUtils implements MethodInterceptor{
    private Object realObject;// 引入被代理对象

    // 构造方法，引入被代理的对象（父类）
    public CGLibProxyUtils(Object realObject) {
        this.realObject = realObject;
    }

    // 重写intercept方法，定义增强动作（前增强，后增强，环绕增强）
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLib 前增强");
        // 使用方法代理对象，回调父类的方法，处理原本业务
        Object result = methodProxy.invokeSuper(o, args);
        System.out.println("CGLib 后增强");
        return result;
    }

    // 获取代理对象（增强对象）
    public Object getEnhanceInstance() {
        // 1、创建增强器，用于(给代理类)设置父类，设置回调方法
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.realObject.getClass());
        // 2、设置一个Callback对象，当前对象实现了MethodInterceptor接口，而MethodInterceptor extends Callback
        // 故参数传入自己this即可
        enhancer.setCallback(this);
        // 3、创建代理对象并返回实例
        Object o = enhancer.create();
        return o;
    }
}
