package com.wtc.study.java8.stream.sixth.demo04;

import com.wtc.study.java8.stream.fourth.demo01.Dish;
import com.wtc.study.java8.stream.fourth.demo01.Type;
import com.wtc.study.java8.utils.ListUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 分区 partitioningBy
 *
 * 分区是分组的特殊情况
 * partitioningBy()中的参数必须是一个布尔值的函数
 * 它最多可以分为两组：true是一组， false是一组
 *
 * @author 吴天成
 * @create 2019/4/5
 * @since 1.0.0
 */
public class Demo01 {

    public static void main(String[] args) {
        List<Dish> dishs = ListUtils.getDishs();

        System.out.println("========把菜单按照素食和非素食分开=============");
        method1(dishs);

        System.out.println("========另一种实现方式========");
        dishs.stream()
                .filter(Dish::getVegetarian)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("========在素食和非素食下按类型对分组========");
        method2(dishs);

        System.out.println("========素食和非素食中热量最高的菜==========");
        method3(dishs);

        System.out.println("========素食和非素食中热量大于500的菜==========");
        method4(dishs);

        System.out.println("========统计素食和非素食的数量==========");
        method5(dishs);
//        System.out.println("==================");
    }

    private static void method5(List<Dish> dishs) {
        Map<Boolean, Long> collect = dishs.stream()
                .collect(Collectors.partitioningBy(Dish::getVegetarian, Collectors.counting()));
        System.out.println(collect);
    }

    private static void method4(List<Dish> dishs) {
        Map<Boolean, Map<Boolean, List<Dish>>> collect = dishs.stream()
                .collect(Collectors.partitioningBy(
                        Dish::getVegetarian,
                        Collectors.partitioningBy(
                                d -> d.getCalories() > 500)
                        )
                );
        for (Boolean aBoolean : collect.keySet()) {
            System.out.println(aBoolean + ":" + collect.get(aBoolean));
        }
    }

    private static void method3(List<Dish> dishs) {
        Map<Boolean, Dish> collect = dishs.stream()
                .collect(
                        Collectors.partitioningBy(
                                Dish::getVegetarian,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparing(Dish::getCalories)),
                                        Optional::get)
                        )
                );
        System.out.println(collect);
    }

    private static void method2(List<Dish> dishs) {
        Map<Boolean, Map<Type, List<Dish>>> collect = dishs.stream()
                .collect(
                        Collectors.partitioningBy(
                                Dish::getVegetarian,
                                Collectors.groupingBy(Dish::getType)
                        )
                );

        for (Boolean aBoolean : collect.keySet()) {
            Map<Type, List<Dish>> typeListMap = collect.get(aBoolean);
            System.out.println(aBoolean + ":" + typeListMap);
        }
    }

    private static void method1(List<Dish> dishs) {
        Map<Boolean, Set<Dish>> collect = dishs.stream()
                .collect(Collectors.partitioningBy(Dish::getVegetarian, Collectors.toSet()));
        for (Boolean aBoolean : collect.keySet()) {
            System.out.println(aBoolean + ":" + collect.get(aBoolean));
        }
    }
}