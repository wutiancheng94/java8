package com.wtc.study.java8.stream.fourth.demo02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author 吴天成
 * @create 2019/4/1
 * @since 1.0.0
 */
public class StreamDemo02 {

    public static void main(String[] args) {
//        method01();
//        method02();
        method03();
        method04();
    }

    /**
     * steam是内部迭代
     */
    private static void method04() {
        List<String> names = new ArrayList<>();
        List<String> list = Arrays.asList("Java8", "In", "Action");
        list.stream().forEach(a -> names.add(a.toUpperCase()));
        System.out.println(names);
    }

    /**
     * 集合的外部迭代
     */
    private static void method03() {
        List<String> names = new ArrayList<>();
        List<String> list = Arrays.asList("Java8", "In", "Action");
        for (String s : list) {
            names.add(s);
        }
        System.out.println(names);
    }

    /**
     * stream只能遍历一次
     */
    private static void method02() {
        List<String> list = Arrays.asList("Java8", "In", "Action");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
        stream.forEach(System.out::println);
    }

    private static void method01() {
        List<String> list = Arrays.asList("Java8", "In", "Action");
        list.stream().forEach(System.out::println);
        list.stream().forEach(System.out::println);
    }
}