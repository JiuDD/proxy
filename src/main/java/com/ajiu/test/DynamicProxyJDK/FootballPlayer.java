package com.ajiu.test.DynamicProxyJDK;

/**
 * description: Player接口的实现类---足球运动员
 * @author: JiuDongDong
 * date: 2018/8/15.
 */
public class FootballPlayer implements Player {
    @Override
    public void play() {
        System.out.println("踢足球！！！");
    }
}
