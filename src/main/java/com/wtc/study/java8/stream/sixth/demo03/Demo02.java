package com.wtc.study.java8.stream.sixth.demo03;

import com.wtc.study.java8.stream.fourth.demo01.Dish;
import com.wtc.study.java8.stream.fourth.demo01.Type;
import com.wtc.study.java8.utils.ListUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 多级分组
 *
 * @author 吴天成
 * @create 2019/4/5
 * @since 1.0.0
 */
public class Demo02 {

    public static void main(String[] args) {
        List<Dish> dishs = ListUtils.getDishs();

        System.out.println("对菜单中的菜肴按照类型和热量进行分组");
        method1(dishs);

        System.out.println("菜单中每类菜有多少个");
        method2(dishs);

        System.out.println("每类菜中热量最高的菜肴");
        method3(dishs);
        method4(dishs);

        System.out.println("对于每种类型的Dish，菜单中都有哪些CaloricLevel");
        method5(dishs);
        method6(dishs);
    }

    private static void method6(List<Dish> dishs) {
        Map<Type, Map<CaloricLevel, HashSet<Dish>>> collect = dishs.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.groupingBy(
                                d -> {
                                    if (d.getCalories() < 400) {
                                        return CaloricLevel.DIET;
                                    } else if (d.getCalories() >= 400 && d.getCalories() <= 700) {
                                        return CaloricLevel.NORMAL;
                                    } else {
                                        return CaloricLevel.FAT;
                                    }
                                }, Collectors.toCollection(HashSet::new))
                        )

                );

        System.out.println(collect);
    }

    private static void method5(List<Dish> dishs) {
        Map<Type, Map<CaloricLevel, Set<Dish>>> collect = dishs.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.groupingBy(
                                d -> {
                                    if (d.getCalories() < 400) {
                                        return CaloricLevel.DIET;
                                    } else if (d.getCalories() >= 400 && d.getCalories() <= 700) {
                                        return CaloricLevel.NORMAL;
                                    } else {
                                        return CaloricLevel.FAT;
                                    }
                                }, Collectors.toSet())
                        )
                );

        System.out.println(collect);
    }

    private static void method4(List<Dish> dishs) {
        Map<Type, Dish> collect = dishs.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Dish::getCalories)),
                                Optional::get)
                        )
                );
        System.out.println(collect);
    }

    private static void method3(List<Dish> dishs) {
        Map<Type, Optional<Dish>> collect = dishs.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparing(Dish::getCalories))));
        System.out.println(collect);
    }

    private static void method2(List<Dish> dishs) {
        Map<Type, Long> collect = dishs.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(collect);
    }

    private static void method1(List<Dish> dishs) {
        Map<Type, Map<CaloricLevel, List<Dish>>> collect = dishs.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.groupingBy(
                                d -> {
                                    if (d.getCalories() < 400) {
                                        return CaloricLevel.DIET;
                                    } else if (d.getCalories() >= 400 && d.getCalories() <= 700) {
                                        return CaloricLevel.NORMAL;
                                    } else {
                                        return CaloricLevel.FAT;
                                    }
                                }
                        )
                        )
                );
        System.out.println(collect);
    }
}