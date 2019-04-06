package com.wtc.study.java8.stream.sixth.demo04;


import com.wtc.study.java8.stream.fourth.demo01.Dish;
import com.wtc.study.java8.stream.fourth.demo01.Type;
import com.wtc.study.java8.utils.ListUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Collectors类的静态工厂方法
 *
 * @author 吴天成
 * @create 2019/4/5
 * @since 1.0.0
 */
public class Demo02 {

    public static void main(String[] args) {
        List<Dish> dishs = ListUtils.getDishs();

        System.out.println("=========把流中所有项目收集到一个 List===========");
        List<Dish> collect = dishs.stream().collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("=========把流中所有项目收集到一个 Set, 删除重复项===========");
        Set<Dish> collect1 = dishs.stream().collect(Collectors.toSet());
        System.out.println(collect1);

        System.out.println("=========把流中所有项目收集到给定的供应源创建的集合===========");
        ArrayList<Dish> collect2 = dishs.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect2);

        System.out.println("=========计算流中元素的个数===========");
        Long collect3 = dishs.stream().collect(Collectors.counting());
        System.out.println(collect3);

        System.out.println("==========对流中项目的一个整数属性求和==========");
        Integer collect4 = dishs.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("热量总和：" + collect4);

        System.out.println("==========计算流中项目 Integer 属性的平均值==========");
        Double collect5 = dishs.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        System.out.println("热量均值：" + collect5);

        System.out.println("==========收集关于流中项目 Integer 属性的统计值，例如最大、最小、总和与平均值==========");
        DoubleSummaryStatistics collect6 = dishs.stream().collect(Collectors.summarizingDouble(Dish::getCalories));
        System.out.println("热量最大值：" + collect6.getMax());

        System.out.println("=========连接对流中每个项目调用 toString 方法所生成的字符串===========");
        System.out.println("以‘，’分割，以‘-’为前缀，以‘*’为后缀");
        String collect7 = dishs.stream().map(Dish::getName).collect(Collectors.joining(",", "-", "*"));
        System.out.println(collect7);

        System.out.println("=========按照给定比较器选出的最大元素===========");
        Optional<Dish> collect8 = dishs.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
        System.out.println(collect8.orElse(null));

        System.out.println("========按照给定比较器选出的最小元素============");
        dishs.stream()
                .collect(Collectors.minBy(Comparator.comparing(Dish::getCalories)))
                .ifPresent(s -> System.out.println(s));

        System.out.println("========从一个作为累加器的初始值开始，利用 BinaryOperator 与流中的元素逐个结合，从而将流归约为单个值============");
        Integer collect9 = dishs.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println("归约方式进行热量求和：" + collect9);

        System.out.println("=======包裹另一个收集器，对其结果应用转换函数  计算流中元素的个数=============");
        Integer collect10 = dishs.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
        System.out.println(collect10);

        System.out.println("=========按类型分组===========");
        Map<Type, List<Dish>> collect11 = dishs.stream().collect(Collectors.groupingBy(Dish::getType));
        for (Type type : collect11.keySet()) {
            System.out.println(type + ":" + collect11.get(type));
        }

        System.out.println("========根据对流中每个项目应用谓词的结果来对项目进行分区============");
        Map<Boolean, List<Dish>> collect12 = dishs.stream().collect(Collectors.partitioningBy(Dish::getVegetarian));
        for (Boolean aBoolean : collect12.keySet()) {
            System.out.println(aBoolean + ":" +  collect12.get(aBoolean));
        }

    }

}