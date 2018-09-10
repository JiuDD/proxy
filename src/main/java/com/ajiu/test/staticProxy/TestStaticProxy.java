package com.ajiu.test.staticProxy;

/**
 * description: 这个类是静态代理的测试类
 * @author: JiuDongDong
 * date: 2018/8/19.
 */
public class TestStaticProxy {
    // 测试方法：代理类里写main方法，使用代理类的对象进行测试
    public static void main(String[] args) {
        // new一个被代理类（核心类）的实例
        CoderModifyBug coderModifyBug = new CoderModifyBugImpl();
        // 然后new一个代理类实例，准备处理业务（包含核心业务、增强业务）
        ProxyCoderModifyBug proxyCoderModifyBug = new ProxyCoderModifyBug(coderModifyBug);
        // 代理类处理业务
        proxyCoderModifyBug.modifyBug();
    }
}
