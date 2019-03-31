package com.wtc.study.java8.lambda.demo07;

import com.wtc.study.java8.lambda.demo01.Apple;
import com.wtc.study.java8.lambda.utils.AppleUtils;

import java.util.Comparator;
import java.util.List;

/**
 * 根据颜色对苹果进行排序
 *
 * @author 吴天成
 * @create 2019/3/31
 * @since 1.0.0
 */
public class FilterApple07 {

    public static void main(String[] args) {
        List<Apple> apples = AppleUtils.getApples();

        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println(apples);

        apples.sort((o1, o2) -> -(o1.getWeight().compareTo(o2.getWeight())));
        System.out.println(apples);

        apples.sort(Comparator.comparing(Apple::getColor));
        System.out.println(apples);
    }
}