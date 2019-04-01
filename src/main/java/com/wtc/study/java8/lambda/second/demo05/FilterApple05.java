package com.wtc.study.java8.lambda.second.demo05;

import com.wtc.study.java8.lambda.second.demo01.Apple;
import com.wtc.study.java8.lambda.utils.AppleUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用lambda
 *
 * @author 吴天成
 * @create 2019/3/31
 * @since 1.0.0
 */
public class FilterApple05 {

    public static void main(String[] args) {
        List<Apple> apples = AppleUtils.getApples();
        System.out.println(filterApple(apples, (Apple a) -> "red".equals(a.getColor())));
    }

    private static List<Apple> filterApple(List<Apple> apples, Predicate predicate) {
        List<Apple> screenApple = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                screenApple.add(apple);
            }
        }

        return screenApple;
    }
}