package com.wtc.study.java8.eighth.design.observer;


import com.wtc.study.java8.eighth.design.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Feed类在内部维护了一个观察者列表，一条新闻到达时，它就进行通知
 *
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public class Feed implements Subject {

    private List<Observer> observers;

    public Feed() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(observer -> observer.notify(tweet));
    }
}