package com.wtc.study.java8.stream.fourth.demo03;

import com.wtc.study.java8.stream.fourth.demo01.Dish;
import com.wtc.study.java8.utils.ListUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 归约
 *
 * @author 吴天成
 * @create 2019/4/1
 * @since 1.0.0
 */
public class ReduceDemo {

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1,2,3,4,5);
        //  元素求和
        method1(ints);

        method2(ints);

        method3(ints);

        //  求最大值和最小值
        ints.stream().reduce(Integer::max).ifPresent(s -> System.out.println("最大值：" + s));
        ints.stream().reduce(Integer::min).ifPresent(s -> System.out.println("最小值：" + s));

        //  用map和reduce方法数一数流中有多少个菜
        List<Dish> dishs = ListUtils.getDishs();
        Optional<Integer> reduce = dishs.stream()
                .distinct()
                .map(d -> 1)
                .reduce(Integer::sum);
        if (reduce.isPresent()) {
            System.out.println(reduce.get());
        }
    }

    private static void method3(List<Integer> ints) {
        ints.stream().reduce(Integer::sum).ifPresent(System.out::println);
    }

    private static void method2(List<Integer> ints) {
        System.out.println(ints.stream().reduce(0, (x, y) -> x + y));
    }


    private static void method1(List<Integer> ints) {
        int sum = 0;
        for (Integer anInt : ints) {
            sum += anInt;
        }
        System.out.println(sum);
    }
}