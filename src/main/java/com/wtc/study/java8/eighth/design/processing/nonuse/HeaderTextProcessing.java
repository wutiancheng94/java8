package com.wtc.study.java8.eighth.design.processing.nonuse;

/**
 *
 * 头文件处理
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public class HeaderTextProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWork(String input) {
        return "From Raoul, Mario and Alan: " + input;
    }
}