package com.wtc.study.java8.lambda.third.demo04;

import com.wtc.study.java8.lambda.second.demo01.Apple;
import com.wtc.study.java8.utils.ListUtils;

import java.util.Comparator;
import java.util.List;

/**
 * @author 吴天成
 * @create 2019/4/1
 * @since 1.0.0
 */
public class AppleSort {

    public static void main(String[] args) {
        List<Apple> apples = ListUtils.getApples();
        apples.sort(Comparator.comparing((Apple a) -> a.getColor()));
        System.out.println(apples);

        apples.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println(apples);
    }

}