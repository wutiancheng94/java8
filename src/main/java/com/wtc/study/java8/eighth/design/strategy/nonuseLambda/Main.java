package com.wtc.study.java8.eighth.design.strategy.nonuseLambda;

/**
 * 主程序
 *
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Validator validator = new Validator(new IsNumericStrategy());
        boolean aaa = validator.validate("aaa");
    }
}