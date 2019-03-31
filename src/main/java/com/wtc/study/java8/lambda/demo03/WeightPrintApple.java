package com.wtc.study.java8.lambda.demo03;

import com.wtc.study.java8.lambda.demo01.Apple;

/**
 * 打印苹果的重量
 *
 * @author 吴天成
 * @create 2019/3/31
 * @since 1.0.0
 */
public class WeightPrintApple implements PrintApple {

    @Override
    public String prettyPrintApple(Apple apple) {
        if (apple.getWeight() > 150) {
            return "这个苹果重" + apple.getWeight() + "g,是重苹果";
        }

        return "这个苹果重" + apple.getWeight() + "g,是轻苹果";
    }
}