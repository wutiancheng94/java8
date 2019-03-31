package com.wtc.study.java8.lambda.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * 需求：
 * 1、筛选绿苹果
 * 2、根据颜色筛选出不同的苹果
 * 3、根据重量筛选出不同的苹果。重的苹果一般是重量大于150克
 *
 * @author 吴天成
 * @create 2019/3/31
 * @since 1.0.0
 */
public class FilterApple {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("green", 100));
        apples.add(new Apple("green", 180));
        apples.add(new Apple("green", 200));
        apples.add(new Apple("red", 100));
        apples.add(new Apple("red", 180));
        apples.add(new Apple("red", 200));

        List<Apple> greenApples = filterGreenApple(apples);
        System.out.println("筛选绿苹果："+ greenApples);

    }


    private static List<Apple> filterGreenApple(List<Apple> apples) {
        List<Apple> greenApples = new ArrayList<>();
        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                greenApples.add(apple);
            }
        }

        return greenApples;
    }

}