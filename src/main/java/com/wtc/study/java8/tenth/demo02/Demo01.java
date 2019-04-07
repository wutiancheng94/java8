package com.wtc.study.java8.tenth.demo02;

import com.wtc.study.java8.tenth.demo02.entity.Car;

import java.util.Optional;

/**
 * 创建 Optional 对象
 *
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public class Demo01 {

    public static void main(String[] args) {
        //  1. 声明一个空的Optional
        Optional<Object> empty = Optional.empty();

        //  2. 依据一个非空值创建Optional
        Car car = new Car();
        // 如果car是一个null， Optional.of会立即抛出一个NullPointerException
        //而不是等到试图访问car的属性值时才返回一个错误
        Optional<Car> optionalCar = Optional.of(car);

        // 3. 可接受null的Optional
        //  如果car是null，那么得到的Optional对象就是个空对象
        Optional<Car> carOptional = Optional.ofNullable(car);

    }
}