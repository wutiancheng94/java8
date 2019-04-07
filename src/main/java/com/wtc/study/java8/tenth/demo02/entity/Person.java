package com.wtc.study.java8.tenth.demo02.entity;

import java.util.Optional;

/**
 * 客户
 *  Optional不能序列化，不能作为类的字段(field)
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public class Person {

    private Optional<Car> car;

    public Optional<Car> getCar() { return car; }
}