package com.ajiu.test.staticProxy;

/**
 * description:
 *      这个接口是静态代理模式中，实现类和实现类的代理类都必需实现的那个接口，
 *      实现类和实现类的代理类都得实现接口定义的方法（本来接口的实现类都得实现接口所有方法）
 *      自己想的一个小案例，思路：
 *      核心业务：程序员修改bug
 *      非核心业务：1、测试人员测试代码，find bug
 *                2、程序员修改完bug后，测试人员复测bug
 * @author: JiuDongDong
 * date: 2018/7/23.
 */
public interface CoderModifyBug {
    // 定义核心业务: 修改bug
    void modifyBug();
}
