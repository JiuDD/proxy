package com.ajiu.test.DynamicProxyCGLib;

/**
 * description: CGLib模式动态代理的目标类，并没有实现像JDK动态代理和静态代理里，需要实现的那个接口
 * @author: JiuDongDong
 * date: 2018/8/17.
 */
public class CoderModifyBug {

    // 父类中，会被子类代理（增强）的方法，修复bug
    public void modifyBug() {
        System.out.println("父类---程序员 修复 bug！！！");
    }
}
