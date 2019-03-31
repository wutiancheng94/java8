package com.wtc.study.java8.lambda.utils;

import com.wtc.study.java8.lambda.demo01.Apple;

import java.util.Arrays;
import java.util.List;

/**
 * @author 吴天成
 * @create 2019/3/31
 * @since 1.0.0
 */
public class AppleUtils {

    public static List<Apple> getApples() {

        return  Arrays.asList(
                new Apple("green", 100),
                new Apple("green", 180),
                new Apple("green", 200),
                new Apple("red", 100),
                new Apple("red", 180),
                new Apple("red", 200));
    }
}