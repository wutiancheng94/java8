package com.wtc.study.java8.eighth.design.strategy.useLambda;

import com.wtc.study.java8.eighth.design.strategy.nonuseLambda.Validator;

/**
 * 主程序
 *
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        boolean validate = new Validator(s -> s.matches("[a-z]+")).validate("bbb");
    }
}