package com.ajiu.test.DynamicProxyCGLib;

/**
 * description: CGLib动态代理的测试类
 * @author: JiuDongDong
 * date: 2018/8/17.
 */
public class TestCGLibDynamicProxy {
    public static void main(String[] args) {
        // 创建被代理对象
        CoderModifyBug coderModifyBug = new CoderModifyBug();
        // 创建代理对象（增强对象）
        CGLibProxyUtils cgLibProxyUtils = new CGLibProxyUtils(coderModifyBug);
        Object enhanceInstance = cgLibProxyUtils.getEnhanceInstance();
        // 打印，输出：true，说明确实是CoderModifyBug父类的子类
        System.out.println(enhanceInstance instanceof CoderModifyBug);// true
        // 转换成CoderModifyBug类型
        CoderModifyBug proxy = (CoderModifyBug) enhanceInstance;
        // 使用代理（增强）对象处理业务
        proxy.modifyBug();
    }
}
