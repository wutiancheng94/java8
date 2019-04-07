package com.wtc.study.java8.eighth.design.strategy.nonuseLambda;

/**
 * 只包含小写字母
 *
 * 2、一个或多个该接口的具体实现，它们代表了算法的多种实现
 *
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public class IsAllLowerCaseStrategy implements ValidationStrategy {

    @Override
    public boolean execute(String s) {

        return s.matches("[a-z]+");
    }
}