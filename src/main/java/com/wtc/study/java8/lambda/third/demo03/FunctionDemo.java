package com.wtc.study.java8.lambda.third.demo03;

import com.wtc.study.java8.lambda.second.demo01.Apple;
import com.wtc.study.java8.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author 吴天成
 * @create 2019/4/1
 * @since 1.0.0
 */
public class FunctionDemo {

    public static void main(String[] args) {
        List<Apple> apples = ListUtils.getApples();
        System.out.println(map(apples, Apple::getWeight));
    }

    public static <T, R>List<R> map(List<T> list, Function<T, R> function) {
        List<R> newList = new ArrayList<>();

        for (T t : list) {
            newList.add(function.apply(t));
        }

        return newList;
    }
}