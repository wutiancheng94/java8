package com.wtc.study.java8.stream.fourth.demo03;

import com.wtc.study.java8.stream.fourth.demo01.Dish;
import com.wtc.study.java8.stream.fourth.demo01.Type;
import com.wtc.study.java8.utils.ListUtils;

import java.util.List;

/**
 * 匹配
 *
 * 属于短路运算
 *
 * @author 吴天成
 * @create 2019/4/1
 * @since 1.0.0
 */
public class MatchDemo {

    public static void main(String[] args) {
        List<Dish> dishs = ListUtils.getDishs();

        System.out.println("菜单里面是否有素食(至少匹配一个元素):" +
                dishs.stream()
                        .anyMatch(s -> s.getType() == Type.MEAT));

        System.out.println("所有菜的热量都低于1000卡路里:" +
                dishs.stream().allMatch(s -> s.getCalories() < 1000));

        System.out.println("所有菜的热量都低于1000卡路里:" +
                dishs.stream().noneMatch(s -> s.getCalories() >= 1000));

    }
}