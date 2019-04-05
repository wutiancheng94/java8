package com.wtc.study.java8.stream.sixth.demo01;

import com.wtc.study.java8.stream.fourth.demo01.Dish;
import com.wtc.study.java8.utils.ListUtils;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 汇总：
 *  -- 求和
 *  -- 均值
 *  -- 最大值
 *  -- 最小值
 *  -- 总个数
 *
 * @author 吴天成
 * @create 2019/4/5
 * @since 1.0.0
 */
public class Demo02 {

    public static void main(String[] args) {
        List<Dish> dishs = ListUtils.getDishs();

        System.out.println("求出菜单列表的总热量：");

        System.out.println("=======方法1  sum========");
        System.out.println(dishs.stream().mapToInt(Dish::getCalories).sum());

        System.out.println("=======方法2  map-reduce========");
        System.out.println(dishs.stream().mapToInt(Dish::getCalories).reduce(0, (x, y) -> x + y));

        System.out.println("=======方法4  Collectors.summarizingInt========");
        method1(dishs);

        System.out.println("把菜单中所有菜肴的名称连接起来：");
        System.out.println(dishs.stream().map(Dish::getName).reduce("", (x, y) -> x + ","+ y));
        method2(dishs);
    }

    private static void method2(List<Dish> dishs) {
        System.out.println("使用Collectors.joining");
        System.out.println(dishs.stream().map(Dish::getName).collect(Collectors.joining(",")));
    }

    private static void method1(List<Dish> dishs) {
        System.out.println("Collectors.summarizingInt获取总和、个数、最大值、最小值、平均值：");
        IntSummaryStatistics collect = dishs.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println("热量的Sum：" + collect.getSum());
        System.out.println("热量的Average：" + collect.getAverage());
        System.out.println("热量的Max：" + collect.getMax());
        System.out.println("热量的Min：" + collect.getMin());
        System.out.println("热量的Count：" + collect.getCount());
    }
}