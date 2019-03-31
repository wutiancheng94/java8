package com.wtc.study.java8.lambda.utils;

import com.wtc.study.java8.lambda.demo01.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴天成
 * @create 2019/3/31
 * @since 1.0.0
 */
public class AppleUtils {

    public static List<Apple> getApples() {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("green", 100));
        apples.add(new Apple("green", 180));
        apples.add(new Apple("green", 200));
        apples.add(new Apple("red", 100));
        apples.add(new Apple("red", 180));
        apples.add(new Apple("red", 200));
        return apples;
    }
}