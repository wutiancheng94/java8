package com.wtc.study.java8.eighth.design.observer;

import com.wtc.study.java8.eighth.design.observer.observer.Observer;

/**
 * 〈主题〉
 *
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public interface Subject {
    /**
     * 注册观察者
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 通知观察者
     * @param tweet
     */
    void notifyObservers(String tweet);
}