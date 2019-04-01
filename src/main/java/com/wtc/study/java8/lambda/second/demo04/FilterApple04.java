package com.wtc.study.java8.lambda.second.demo04;

import com.wtc.study.java8.lambda.second.demo01.Apple;
import com.wtc.study.java8.lambda.second.demo02.Predicate;
import com.wtc.study.java8.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用匿名内部类实现策略模式，减少类文件
 *
 * @author 吴天成
 * @create 2019/3/31
 * @since 1.0.0
 */
public class FilterApple04 {

    public static void main(String[] args) {
        List<Apple> apples = ListUtils.getApples();

        System.out.println("筛选绿苹果："+ filterApple(apples, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return "green".equals(apple.getColor());
            }
        }));

        System.out.println("筛选出体重大于150g的苹果" + filterApple(apples, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return 150 < apple.getWeight();
            }
        }));
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