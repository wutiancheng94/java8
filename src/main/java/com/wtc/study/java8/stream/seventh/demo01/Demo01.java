package com.wtc.study.java8.stream.seventh.demo01;

import java.util.stream.Stream;

/**
 * 并行流内部使用了默认的ForkJoinPool，
 * 默认的线程数量就是处理器数量（ Runtime.getRuntime().availableProcessors()）
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public class Demo01 {

    public static void main(String[] args) {

        System.out.println("=======将顺序流转换为并行流==========");
        method1();

        System.out.println("=======顺序还是并行取决于最后一次调用==========");
        method2();
    }

    private static void method2() {
        Stream.iterate(0, i ->i + 1)
                .parallel()
                .limit(200)
                .sequential()
                .forEach(System.out::println);
    }

    private static void method1() {
        Integer reduce = Stream.iterate(0, i -> i + 1)
                .parallel()
                .limit(200)
                .reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}