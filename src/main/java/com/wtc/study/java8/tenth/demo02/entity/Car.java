package com.wtc.study.java8.tenth.demo02.entity;

import java.util.Optional;

/**
 * 汽车
 *
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public class Car {
    private Optional<Insurance> insurance;
    public Optional<Insurance> getInsurance() { return insurance; }
}