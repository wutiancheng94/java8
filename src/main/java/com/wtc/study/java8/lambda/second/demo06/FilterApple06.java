package com.wtc.study.java8.lambda.second.demo06;

import com.wtc.study.java8.lambda.second.demo01.Apple;
import com.wtc.study.java8.lambda.second.demo02.Predicate;
import com.wtc.study.java8.utils.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 将List类型抽象化，使filter方法过滤能力更强
 *
 * @author 吴天成
 * @create 2019/3/31
 * @since 1.0.0
 */
public class FilterApple06 {

    public static void main(String[] args) {
        List<Apple> apples = ListUtils.getApples();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        System.out.println(filter(apples, (p) -> "red".equals(p.getColor())));

        System.out.println(filter(numbers, (i) -> i % 2 == 0));
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                newList.add(t);
            }
        }

        return newList;
    }
}