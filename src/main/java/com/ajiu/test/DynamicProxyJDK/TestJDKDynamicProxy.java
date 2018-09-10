package com.ajiu.test.DynamicProxyJDK;

import java.lang.reflect.Proxy;

/**
 * description: 如何调用动态代理类干活
 *      这个类是JDK动态代理的测试类
 * @author: JiuDongDong
 * date: 2018/8/16.
 */
public class TestJDKDynamicProxy {
    // 如何使用动态代理类实例做增强工作？如下：
    public static void main(String[] args) {
        // 第一步：new一个被代理类
        BasketballPlayerImpl player = new BasketballPlayerImpl();

        // 第二步：根据“被代理类”，“动态”地生成动态代理类的实例。如何生成？
        // 首先new一个InvocationHandler接口的实现类
        // 然后使用java.lang.reflect.Proxy的静态生成代理类实例的方法“动态”地生成动态代理类的实例
        // Proxy的new动态代理对象的3个参数：
        // 1、类加载器，用来加载动态生成的存储在内存中的代理类的.class字节码文件
        // （静态代理的方式，是程序员写的java文件被编译成.class文件存储在硬盘中，
        // 项目启动时，由类加载器读取硬盘上的字节码文件进行加载，生成静态代理对象）
        // 2、要实现的接口的类对象
        // 3、InvocationHandler的实现类的实例

        // 以下准备参数
        // 使用加载接口的那个类加载器，也可以使用系统的类加载器ClassLoader.getSystemClassLoader()
        ClassLoader classLoader = Player.class.getClassLoader();
        Class[] classes = {Player.class};//类对象集合，放入接口的类对象即可
        Object o = Proxy.newProxyInstance(classLoader, classes, new InvocationHandlerImpl(player));
        // 第二步2：其实这个动态代理类实例就是接口Player的增强实现类而已，将其转换成Player
        Player proxy = (Player) o;// 这个proxy对象就是运行时动态生成的代理类实例
        // 第三步：动态代理类的实例做增强工作
        proxy.play();
    }
}
