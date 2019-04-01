package com.wtc.study.java8.lambda.second.demo02;

import com.wtc.study.java8.lambda.second.demo01.Apple;

/**
 * 筛选重的苹果
 *
 * @author 吴天成
 * @create 2019/3/31
 * @since 1.0.0
 */
public class AppleHeavyWeightPredicate implements Predicate<Apple> {

    @Override
    public boolean test(Apple apple) {
        return 150 < apple.getWeight();
    }
}