package com.ajiu.test.staticProxy;

/**
 * description: 这个类是个代理类，是接口的实现类CoderModifyBug的代理类，要点有3：
 *      1、实现了被代理类的modifyBug()方法
 *      2、在这个被代理类的modifyBug()方法中，实际是调用被代理类的这个方法处理核心业务
 *      3、在这个代理类的modifyBug()方法中，不仅调用核心类实例处理了核心业务，
 *      另外：自定义了一些额外功能，进行了增强来处理非核心业务
 * @author: JiuDongDong
 * date: 2018/7/23.
 */
public class ProxyCoderModifyBug implements CoderModifyBug {
    private CoderModifyBug coderModifyBug;
    // 这个构造方法的目的：传递被代理类的实现类的对象进行，处理核心业务
    public ProxyCoderModifyBug(CoderModifyBug coderModifyBug) {
        this.coderModifyBug = coderModifyBug;
    }

    // 代理类的对象处理业务，业务包含：非核心业务、核心业务
    @Override
    public void modifyBug() {
        // 1、测试人员find bug------------代理类做非核心业务
        preHandler();
        // 2、调用核心类的modifyBug()方法修复bug---核心实现类类做核心业务
        coderModifyBug.modifyBug();
        // 3、测试人员复测bug
        suffixHandler();
    }

    /**
     * Description: 前置增强---代理类的功能（前置和后置合起来即为环绕增强）
     */
    private void preHandler() {
        System.out.println("代理类做非核心业务-----测试人员find bug！！！");
    }

    /**
     * Description: 后置增强---代理类的功能
     */
    private void suffixHandler() {
        System.out.println("代理类做非核心业务-----测试人员复测bug！！！");
    }
}
