package com.wtc.study.java8.lambda.second.demo03;

import com.wtc.study.java8.lambda.second.demo01.Apple;
import com.wtc.study.java8.utils.ListUtils;

import java.util.List;

/**
 * 测试2.1 编写灵活的prettyPrintApple方法
 *
 * @author 吴天成
 * @create 2019/3/31
 * @since 1.0.0
 */
public class FilterApple03 {

    public static void main(String[] args) {
        List<Apple> apples = ListUtils.getApples();
        prettyPrintApple(apples, new WeightPrintApple());
        prettyPrintApple(apples, new ColorPrintApple());
    }

    public static void prettyPrintApple(List<Apple> apples, PrintApple printApple) {
        for (Apple apple : apples) {
            System.out.println(printApple.prettyPrintApple(apple));
        }
    }
}