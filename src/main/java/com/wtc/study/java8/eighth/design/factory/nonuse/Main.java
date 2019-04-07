package com.wtc.study.java8.eighth.design.factory.nonuse;

import com.wtc.study.java8.eighth.design.factory.entity.Product;

/**
 * 工厂模式
 *
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Product product = ProductFactory.createProduct("loan");
    }
}