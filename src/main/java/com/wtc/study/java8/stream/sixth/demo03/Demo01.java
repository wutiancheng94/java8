package com.wtc.study.java8.stream.sixth.demo03;

import com.wtc.study.java8.stream.fourth.demo01.Dish;
import com.wtc.study.java8.stream.fourth.demo01.Type;
import com.wtc.study.java8.utils.ListUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分组
 *
 * @author 吴天成
 * @create 2019/4/5
 * @since 1.0.0
 */
public class Demo01 {

    public static void main(String[] args) {
        List<Dish> dishs = ListUtils.getDishs();

        System.out.println("把菜单中的菜按照类型进行分类:");
        method1(dishs);

        System.out.println("按热量分类（<400为diet, 400~700为normal, >700为fat）");
        method2(dishs);
    }

    private static void method2(List<Dish> dishs) {
        Map<CaloricLevel, List<Dish>> collect = dishs.stream()
                .collect(Collectors.groupingBy(
                        d -> {
                            if (d.getCalories() < 400) {
                                return CaloricLevel.DIET;
                            } else if (d.getCalories() >= 400 && d.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        }
                ));
        for (CaloricLevel caloricLevel : collect.keySet()) {
            System.out.println(caloricLevel + ":" + collect.get(caloricLevel));
        }
    }

    private static void method1(List<Dish> dishs) {
        Map<Type, List<Dish>> collect = dishs.stream()
                .collect(Collectors.groupingBy(Dish::getType));
        for (Type type : collect.keySet()) {
            System.out.println(type + ":" + collect.get(type));
        }


    }
}