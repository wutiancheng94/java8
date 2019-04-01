package com.wtc.study.java8.utils;

import com.wtc.study.java8.lambda.second.demo01.Apple;
import com.wtc.study.java8.stream.fourth.demo01.Dish;
import com.wtc.study.java8.stream.fourth.demo01.Type;

import java.util.Arrays;
import java.util.List;

/**
 * @author 吴天成
 * @create 2019/3/31
 * @since 1.0.0
 */
public class ListUtils {

    public static List<Apple> getApples() {

        return  Arrays.asList(
                new Apple("green", 100),
                new Apple("green", 180),
                new Apple("green", 200),
                new Apple("red", 100),
                new Apple("red", 180),
                new Apple("red", 200));
    }

    public static List<Dish> getDishs() {
        return Arrays.asList(
                new Dish("pork", false, 800, Type.MEAT),
                new Dish("beef", false, 700, Type.MEAT),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("season fruit", true, 120, Type.OTHER),
                new Dish("pizza", true, 550, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("salmon", false, 450, Type.FISH) );
    }
}