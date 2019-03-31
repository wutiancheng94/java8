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

        String color = "red";
        List<Apple> colorApples = filterAppleByColor(apples, color);
        System.out.println("根据颜色筛选出不同的苹果："+ colorApples);

        int weight = 150;
        List<Apple> weightApples = filterAppleByWeight(apples, weight);
        System.out.println("筛选出体重大于150g的苹果" + weightApples);
    }

    private static List<Apple> filterAppleByWeight(List<Apple> apples, int weight) {
        List<Apple> weightApples = new ArrayList<>();

        for (Apple apple : apples) {
            if (weight < apple.getWeight()) {
                weightApples.add(apple);
            }
        }

        return weightApples;
    }

    private static List<Apple> filterAppleByColor(List<Apple> apples, String color) {
        List<Apple> greenApples = new ArrayList<>();

        if (color != null) {
            for (Apple apple : apples) {
                if (color.equals(apple.getColor())) {
                    greenApples.add(apple);
                }
            }
        }

        return greenApples;
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