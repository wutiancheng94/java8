package com.wtc.study.java8.eighth.junit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对流操作中的流水线进行调试：
 *  使用peek输出Stream流水线操作之前和操作之后的中间值
 *
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public class StreamDebugging {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        // 一旦调用forEach，整个流就会恢复运行
        numbers.stream()
                .map(x -> x + 17)
                .filter(x -> x % 2 == 0)
                .limit(3)
                .forEach(System.out::println);

        List<Integer> result =
                numbers.stream()
                        .peek(x -> System.out.println("from stream: " + x))
                        .map(x -> x + 17)
                        .peek(x -> System.out.println("after map: " + x))
                        .filter(x -> x % 2 == 0)
                        .peek(x -> System.out.println("after filter: " + x))
                        .limit(3)
                        .peek(x -> System.out.println("after limit: " + x))
                        .collect(Collectors.toList());
    }
}