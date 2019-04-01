package com.wtc.study.java8.lambda.third.demo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 环绕执行模式
 *
 * @author 吴天成
 * @create 2019/4/1
 * @since 1.0.0
 */
public class executeAround {

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("1.txt")))) {
            System.out.println(processFile(bufferedReader, (s) -> s.readLine()));
            System.out.println(processFile(bufferedReader, (s) -> s.readLine() + s.readLine()));
        }
    }

    public static String processFile(BufferedReader bufferedReader, BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
       return bufferedReaderProcessor.processFile(bufferedReader);
    }
}