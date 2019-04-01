package com.wtc.study.java8.lambda.third.demo03;

import com.wtc.study.java8.lambda.second.demo01.Apple;
import com.wtc.study.java8.lambda.second.demo02.Predicate;
import com.wtc.study.java8.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * predicate
 *
 * @author 吴天成
 * @create 2019/4/1
 * @since 1.0.0
 */
public class PredicateDemo {

    public static void main(String[] args) {
        List<Apple> apples = ListUtils.getApples();
        System.out.println(filter(apples, (Apple a) -> a.getWeight()>150));
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if(predicate.test(t)) {
                newList.add(t);
            }
        }

        return newList;
    }
}