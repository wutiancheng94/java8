package com.wtc.study.java8.design.observer;

import com.wtc.study.java8.design.observer.observer.ANewspaper;
import com.wtc.study.java8.design.observer.observer.BNewspaper;
import com.wtc.study.java8.design.observer.observer.CNewspaper;

/**
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.registerObserver(new ANewspaper());
        feed.registerObserver(new BNewspaper());
        feed.registerObserver(new CNewspaper());

        feed.notifyObservers("围棋节目的后面是篮球节目");
    }
}