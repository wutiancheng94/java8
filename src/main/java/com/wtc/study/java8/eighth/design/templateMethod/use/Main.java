package com.wtc.study.java8.eighth.design.templateMethod.use;

/**
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(1, s -> System.out.println(s.getName() + ",你的红包"));
    }
}