package com.wtc.study.java8.stream.fifth.demo01;

import com.wtc.study.java8.stream.fourth.demo01.Dish;
import com.wtc.study.java8.utils.ListUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 查找
 *
 * @author 吴天成
 * @create 2019/4/1
 * @since 1.0.0
 */
public class FindDemo {

    public static void main(String[] args) {
        List<Dish> dishs = ListUtils.getDishs();
        dishs.stream().map(Dish::getName).forEach(System.out::println);

        System.out.println("找到一道素食菜肴");
        Optional<Dish> dishOptional = dishs.stream()
                .filter(Dish::getVegetarian)
                .findAny();
        dishOptional.ifPresent(s -> System.out.println(s.getName()));

        System.out.println("查找第一道菜");
        dishs.stream()
                .findFirst()
                .ifPresent(s -> System.out.println(s.getName()));

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("找出第一个平方能被3整除的数");
        someNumbers.stream()
                .filter(s -> s * s % 3 == 0)
                .findFirst()
                .ifPresent(s -> System.out.println(s));
    }
}