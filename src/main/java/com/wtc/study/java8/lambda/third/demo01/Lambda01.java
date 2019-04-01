package com.wtc.study.java8.lambda.third.demo01;

import com.wtc.study.java8.lambda.second.demo01.Apple;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 有效的lambda表达式
 * @author 吴天成
 * @create 2019/4/1
 * @since 1.0.0
 */
public class Lambda01 {

    public static void main(String[] args) {
        //  Lambda表达式可以被赋给一个变量
        Function<String, Integer> function = (String s) -> s.length();
        System.out.println("长度：" + function.apply("123"));

        Predicate<Apple> predicate = (apple) -> apple.getWeight() > 150;
        Apple apple = new Apple();
        apple.setWeight(200);
        System.out.println("重苹果吗？" + predicate.test(apple));

        BiConsumer<Integer, Integer> consumer = (x, y)->{
            System.out.print("Result:");
            System.out.println(x + y);
        };
        consumer.accept(1, 3);

        //  Lambda表达式可以传递给一个接受函数式接口作为参数的方法
        //  前提是Lambda表达式的签名要和函数式接口的抽象方法一样
        process(() -> System.out.println("呵呵哒"));

        System.out.println(change("123", (s) -> Integer.parseInt(s)));
    }

    public static void process(Runnable runnable) {
        runnable.run();
    }

    public static int change(String source, MyFunctionInterface func) {
        return func.StringtoInt(source);
    }
}