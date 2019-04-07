package com.wtc.study.java8.design.processing.nonuse;

/**
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        ProcessingObject<String> headerTextProcessing = new HeaderTextProcessing();
        ProcessingObject spellCheckerProcessing = new SpellCheckerProcessing();

        //  将两个处理对象链接起来
        headerTextProcessing.setSuccessor(spellCheckerProcessing);

        String result = headerTextProcessing.handle("Aren't labdas really sexy?!!");
        System.out.println(result);
    }
}