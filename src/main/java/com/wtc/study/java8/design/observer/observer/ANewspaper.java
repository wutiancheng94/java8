package com.wtc.study.java8.design.observer.observer;

import org.apache.commons.lang3.StringUtils;

/**
 * A报社
 *  观察者：依据新闻中不同的关键字分别定义不同的行为
 *
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public class ANewspaper implements Observer {

    @Override
    public void notify(String tweet) {
        if (StringUtils.isNotBlank(tweet) && tweet.contains("围棋")) {
            System.out.println("A报社收到了新闻： " + tweet);
        }
    }
}