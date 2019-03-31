package com.wtc.study.java8.lambda.demo02;

import com.wtc.study.java8.lambda.demo01.Apple;

/**
 * 筛选绿色苹果
 *
 * @author 吴天成
 * @create 2019/3/31
 * @since 1.0.0
 */
public class AppleGreenPredicate implements Predicate<Apple> {

    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}