package com.wtc.study.java8.tenth.demo02.entity;

import java.util.Optional;

/**
 * Optional不能序列化，不能作为类的字段(field)
 * 如果一定要实现序列化的域模型 可以采用下面这种方式
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public class Person2 {
    private Car car;

    public Optional<Car> getCar() {
        return Optional.ofNullable(car);
    }
}