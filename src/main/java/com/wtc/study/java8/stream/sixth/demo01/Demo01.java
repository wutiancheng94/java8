package com.wtc.study.java8.stream.sixth.demo01;

import com.wtc.study.java8.stream.fourth.demo01.Dish;
import com.wtc.study.java8.utils.ListUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author 吴天成
 * @create 2019/4/5
 * @since 1.0.0
 */
public class Demo01 {

    public static void main(String[] args) {
        List<Dish> dishs = ListUtils.getDishs();

        System.out.println("数一数菜单里有多少种菜:");
        System.out.println("=======方法1  count========");
        long count = dishs.stream().count();
        System.out.println(count);

        System.out.println("=======方法2  map-reduce========");
        System.out.println(dishs.stream().mapToInt(d -> 1).reduce(0, (x, y) -> x + y));

        System.out.println("=======方法3  Collectors.counting()========");
        method1(dishs);

        System.out.println("找出菜单中热量最高和最小的菜:");
        System.out.println("=======方法1  max,min========");
        dishs.stream()
                .max(Comparator.comparing(Dish::getCalories))
                .ifPresent(s -> System.out.println("最大值：" + s));
        System.out.println("最小值：" +dishs.stream().min(Comparator.comparing(Dish::getCalories)).orElse(null));

        System.out.println("=======方法2  Collectors.reducing========");
        dishs.stream()
                .collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories()? d1 : d2))
                .ifPresent(s -> System.out.println("最大值:" + s));

        System.out.println("=======方法3  Collectors.maxBy和Collectors.minBy========");
        method2(dishs);

    }

    private static void method2(List<Dish> dishs) {
        Dish max = dishs.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories))).orElse(null);
        System.out.println(max);
        Dish min = dishs.stream().collect(Collectors.minBy(Comparator.comparing(Dish::getCalories))).orElse(null);
        System.out.println(min);
    }

    private static void method1(List<Dish> dishs) {
        Long collect = dishs.stream().collect(Collectors.counting());
        System.out.println(collect);
    }
}