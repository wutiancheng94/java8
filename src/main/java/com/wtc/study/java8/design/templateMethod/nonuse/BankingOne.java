package com.wtc.study.java8.design.templateMethod.nonuse;

import com.wtc.study.java8.design.templateMethod.entity.Customer;

/**
 * 中国人民银行
 *
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public class BankingOne extends OnlineBanking {

    @Override
    void makeCustomerHappy(Customer c) {
        System.out.println("hello" + c.getName() + "，这是你的红包");
    }
}