package com.wtc.study.java8.lambda.demo02;

import com.wtc.study.java8.lambda.demo01.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * 行为参数化  使用策略模式来应对不同的需求
 *
 *  filterApples方法的行为取决于通过Predicate对象传递的代码，也就是说把filterApples方法的行为参数化了！
 * @author 吴天成
 * @create 2019/3/31
 * @since 1.0.0
 */
public class FilterApple02 {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("green", 100));
        apples.add(new Apple("green", 180));
        apples.add(new Apple("green", 200));
        apples.add(new Apple("red", 100));
        apples.add(new Apple("red", 180));
        apples.add(new Apple("red", 200));

        System.out.println("筛选绿苹果："+ filterApple(apples, new AppleGreenPredicate()));

        System.out.println("筛选出体重大于150g的苹果" + filterApple(apples, new AppleHeavyWeightPredicate()));
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