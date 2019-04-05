package com.wtc.study.java8.stream.sixth.demo02;

import com.wtc.study.java8.stream.fourth.demo01.Dish;
import com.wtc.study.java8.utils.ListUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 广义的归约
 *
 * @author 吴天成
 * @create 2019/4/5
 * @since 1.0.0
 */
public class Demo01 {

    public static void main(String[] args) {
        List<Dish> dishs = ListUtils.getDishs();

        System.out.println("菜单热量的sum：");
        Integer sum1 = dishs.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        Integer sum2 = dishs.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        int sum3 = dishs.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum1 + "\t" + sum2 + "\t" + sum3);

        System.out.println("菜单个数:" +
                dishs.stream().collect(Collectors.reducing(0, d -> 1, Integer::sum)));

    }
}