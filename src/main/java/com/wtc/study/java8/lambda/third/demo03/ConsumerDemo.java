package com.wtc.study.java8.lambda.third.demo03;

import com.wtc.study.java8.lambda.second.demo01.Apple;
import com.wtc.study.java8.utils.ListUtils;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author 吴天成
 * @create 2019/4/1
 * @since 1.0.0
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        List<Apple> apples = ListUtils.getApples();
        consumer(apples, (Apple a) -> System.out.println(a));
    }

    public static <T> void consumer(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}