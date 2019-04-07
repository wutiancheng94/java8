package com.wtc.study.java8.eighth.design.templateMethod.nonuse;

/**
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {

        OnlineBanking bankingOne = new BankingOne();
        bankingOne.processCustomer(2);

        OnlineBanking bankingTwo = new BankingTwo();
        bankingTwo.processCustomer(1);
    }
}