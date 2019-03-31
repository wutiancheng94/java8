package com.wtc.study.java8.lambda.demo03;

import com.wtc.study.java8.lambda.demo01.Apple;

/**
 * 以多种方式根据苹果生成一个String输出
 *
 * @author 吴天成
 * @create 2019/3/31
 * @since 1.0.0
 */
public interface PrintApple {

    String prettyPrintApple(Apple apple);
}