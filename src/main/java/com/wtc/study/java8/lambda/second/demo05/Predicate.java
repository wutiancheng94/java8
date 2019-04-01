package com.wtc.study.java8.lambda.second.demo05;

import com.wtc.study.java8.lambda.second.demo01.Apple;

/**
 * 〈过滤接口〉
 *
 * @author 吴天成
 * @create 2019/3/31
 * @since 1.0.0
 */
public interface Predicate {

    boolean test(Apple apple);
}