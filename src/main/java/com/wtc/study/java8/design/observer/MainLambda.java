package com.wtc.study.java8.design.observer;

import org.apache.commons.lang3.StringUtils;

/**
 * 观察者的逻辑有可能十分复杂，它们可能还持有状态，抑或定义了多个方法，诸如此类。
 * 在这些情形下，还是应该继续使用类的方式而不是lambda。
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public class MainLambda {

    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.registerObserver((String tweet) -> {
            if (StringUtils.isNotBlank(tweet) && tweet.contains("围棋")) {
                System.out.println("A报社收到了新闻： " + tweet);
            }
        });

        feed.registerObserver((String tweet) -> {
            if (StringUtils.isNotBlank(tweet) && tweet.contains("篮球")) {
                System.out.println("B报社收到了新闻： " + tweet);
            }
        });

        feed.registerObserver((String tweet)-> {
            if (StringUtils.isNotBlank(tweet) && tweet.contains("足球")) {
                System.out.println("C报社收到了新闻： " + tweet);
            }
        });

        feed.notifyObservers("围棋节目的后面是篮球节目");
    }
}