package com.wtc.study.java8.stream.fifth.demo04;

import java.util.stream.Stream;

/**
 * 创建无限流：
 *  -- Stream.iterate
 *  -- Stream.generate
 *
 * @author 吴天成
 * @create 2019/4/4
 * @since 1.0.0
 */
public class Demo02 {

    public static void main(String[] args) {
        System.out.println("========迭代============");
        System.out.println("iterate方法接受一个初始值（在这里是0），还有一个依次应用在每个产生的新值上的Lambda（UnaryOperator<t>类型）");
        method1();

        System.out.println("=======斐波纳契元组序列=======");
        method2();

        System.out.println("======生成=====");
        System.out.println("generate接受一个Supplier<T>类型的Lambda提供新的值");
        method3();

        System.out.println("不能对无限流做排序或归约");
    }

    private static void method3() {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    private static void method2() {
        Stream.iterate(new int[]{0, 1},
//                t -> {
//                    int temp = t[0] + t[1];
//                    t[0] = t[1];
//                    t[1] = temp;
//                    return t;
//                }
                t -> new int[]{t[1], t[0] + t[1]}
        ).limit(10).forEach(t -> System.out.println(t[0] + "," + t[1]));
    }

    private static void method1() {
        Stream.iterate(0, x -> x + 2)
                .limit(10)
                .forEach(System.out::println);
    }
}