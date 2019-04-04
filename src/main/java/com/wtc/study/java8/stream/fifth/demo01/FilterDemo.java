package com.wtc.study.java8.stream.fifth.demo01;

import com.wtc.study.java8.stream.fourth.demo01.Dish;
import com.wtc.study.java8.stream.fourth.demo01.Type;
import com.wtc.study.java8.utils.ListUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 筛选
 *
 * @author 吴天成
 * @create 2019/4/1
 * @since 1.0.0
 */
public class FilterDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        System.out.println(numbers);

        System.out.println("======大于3的元素===========");
        List<Integer> collect1 = numbers.stream()
                .filter(a -> a > 3)
                .collect(Collectors.toList());
        System.out.println(collect1);

        System.out.println("======过滤掉重复元素===========");
        List<Integer> collect2 = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect2);

        System.out.println("====截断流=====");
        List<Integer> collect3 = numbers.stream()
                .filter(i -> i % 2!=0)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(collect3);

        System.out.println("===跳过元素====");
        List<Integer> collect4 = numbers.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(collect4);

        List<Dish> dishs = ListUtils.getDishs();
        System.out.println("利用流来筛选前两个荤菜");
        List<Dish> collect5 =
                dishs.stream()
                    .filter(d -> d.getType().equals(Type.MEAT))
                    .limit(2)
                    .collect(Collectors.toList());
        System.out.println(collect5);
    }
}