package com.wtc.study.java8.design.templateMethod.entity;

import java.util.Arrays;
import java.util.List;

/**
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public class Database {

    public static Customer getCustomerWithId(int id) {
        List<Customer> list = Arrays.asList(
                new Customer(1, "张三"),
                new Customer(2, "李四"),
                new Customer(3, "王五"));

        return list.get(id);
    }
}