package com.ajiu.test.DynamicProxyJDK;

/**
 * description: Player接口的实现类---篮球运动员
 * @author: JiuDongDong
 * date: 2018/8/15.
 */
public class BasketballPlayerImpl implements Player {

    @Override
    public void play() {
        System.out.println("打篮球！！！");
    }
}
