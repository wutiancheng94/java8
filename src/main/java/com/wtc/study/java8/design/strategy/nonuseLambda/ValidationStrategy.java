package com.wtc.study.java8.design.strategy.nonuseLambda;

/**
 * 策略模式
 *
 * 1、代表某个算法的接口
 *
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public interface ValidationStrategy {

    /**
     * 验证输入的内容是否根据标准进行了恰当的格式化
     * @param s
     * @return
     */
    boolean execute(String s);
}