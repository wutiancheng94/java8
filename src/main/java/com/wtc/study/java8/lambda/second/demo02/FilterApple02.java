package com.wtc.study.java8.lambda.second.demo02;

import com.wtc.study.java8.lambda.second.demo01.Apple;
import com.wtc.study.java8.lambda.utils.AppleUtils;

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
        List<Apple> apples = AppleUtils.getApples();

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