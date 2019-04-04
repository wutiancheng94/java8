package com.wtc.study.java8.stream.fourth.demo06;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 创建流
 *
 * @author 吴天成
 * @create 2019/4/4
 * @since 1.0.0
 */
public class Demo01 {

    public static void main(String[] args) {
        System.out.println("由值创建流：");
        method1();

        System.out.println("由数组创建流：");
        method2();

        System.out.println("由文件生成流:");
        method3();


    }

    private static void method3() {
        try(Stream<String> lines = Files.lines(Paths.get("E:\\github\\src\\main\\resources\\1.txt"), Charset.defaultCharset())) {
//            Stream<String[]> stream = lines.map(s -> s.split(""));
            long count = lines.flatMap(lien -> Arrays.stream(lien.split("")))
                    .distinct()
                    .count();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void method2() {
        int[] numbers = {2, 3, 5, 7, 11, 13};
        IntStream stream = Arrays.stream(numbers);
        System.out.println(stream.sum());
    }

    private static void method1() {
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        System.out.println("将字符串转换为大写:");
        stream.map(String::toUpperCase).forEach(System.out::println);
    }
}