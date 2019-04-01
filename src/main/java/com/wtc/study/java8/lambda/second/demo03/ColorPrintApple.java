package com.wtc.study.java8.lambda.second.demo03;

import com.wtc.study.java8.lambda.second.demo01.Apple;

/**
 * 打印苹果的颜色
 *
 * @author 吴天成
 * @create 2019/3/31
 * @since 1.0.0
 */
public class ColorPrintApple implements PrintApple {

    @Override
    public String prettyPrintApple(Apple apple) {
        return "这个苹果的颜色为：" + apple.getColor();
    }
}