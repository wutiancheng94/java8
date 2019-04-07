package com.wtc.study.java8.design.strategy.nonuseLambda;

/**
 * 只包含数字
 *
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public class IsNumericStrategy implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}