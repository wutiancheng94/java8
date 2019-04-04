package com.wtc.study.java8.stream.fifth.demo02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 交易单
 *
 * @author 吴天成
 * @create 2019/4/4
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private Trader trader;

    private int year;

    private int value;
}