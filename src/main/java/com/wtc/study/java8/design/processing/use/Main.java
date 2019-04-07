package com.wtc.study.java8.design.processing.use;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 *  使用lambda
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        UnaryOperator<String> headerTextProcessingLambda
                = (String input) -> "From Raoul, Mario and Alan: " + input;

        UnaryOperator<String> spellCheckerProcessingLambda
                = (String input) -> input.replaceAll("labda", "lambda");

        Function<String, String> pipeline = headerTextProcessingLambda.andThen(spellCheckerProcessingLambda);

        String result = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println(result);
    }
}