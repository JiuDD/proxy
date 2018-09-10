package com.ajiu.test.staticProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * description: 这个类是“被代理类”的实现类，负责实现核心任务
 * @author: JiuDongDong
 * date: 2018/7/23.
 */
public class CoderModifyBugImpl implements CoderModifyBug {
    @Override
    public void modifyBug() {
        // 被代理类的实现类实现接口方法，修复bug
        System.out.println("接口的实现类做核心业务---程序员 修复 bug！！！");
    }

}
