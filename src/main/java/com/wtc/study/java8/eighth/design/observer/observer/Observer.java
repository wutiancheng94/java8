package com.wtc.study.java8.eighth.design.observer.observer;

/**
 * 〈观察者模式〉
 *
 * 情景：有A、B、C 3家报社都订阅了新闻，他们希望当接收的新闻中包含他们感兴趣的关键字时，能得到特别通知。
 *  A感兴趣的关键字是"围棋"、B感兴趣的关键字是"篮球"、C感兴趣的关键字是"足球"
 *
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public interface Observer {

    void notify(String tweet);
}