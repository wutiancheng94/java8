package com.wtc.study.java8.design.processing.nonuse;

/**
 * 拼写检查
 *
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public class SpellCheckerProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWork(String input) {
        return input.replaceAll("labda", "lambda");
    }
}