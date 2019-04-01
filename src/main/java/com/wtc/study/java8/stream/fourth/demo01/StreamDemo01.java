package com.wtc.study.java8.stream.fourth.demo01;

import com.wtc.study.java8.utils.ListUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 吴天成
 * @create 2019/4/1
 * @since 1.0.0
 */
public class StreamDemo01 {

    public static void main(String[] args) {
        List<Dish> menu = ListUtils.getDishs();
        List<String> threeHighCaloricDishName = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
//                .forEach(System.out::println);
                .collect(Collectors.toList());

        System.out.println(threeHighCaloricDishName);
    }
}