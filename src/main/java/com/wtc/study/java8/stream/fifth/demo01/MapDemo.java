package com.wtc.study.java8.stream.fifth.demo01;

import com.wtc.study.java8.stream.fourth.demo01.Dish;
import com.wtc.study.java8.utils.ListUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 映射
 *
 * @author 吴天成
 * @create 2019/4/1
 * @since 1.0.0
 */
public class MapDemo {

    public static void main(String[] args) {
        List<Dish> dishs = ListUtils.getDishs();

        System.out.println("提取流中菜肴的名称");
        dishs.stream()
                .map(Dish::getName)
                .forEach(System.out::println);

        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        System.out.println("显示每个单词中有几个字母");
        words.stream()
                .map(String::length)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("找出每道菜的名称有多长");
        dishs.stream()
                .map(Dish::getName)
                .map(String::length)
                .forEach(System.out::println);

        System.out.println("返回列表中每个单词的长度");
        String[] arrayOfWords = {"Goodbye", "World"};
        List<String[]> collect1 = Stream.of(arrayOfWords)
                .map(a -> a.split(""))
                .collect(Collectors.toList());
        System.out.println(collect1);

        List<String> collect2 = Stream.of(arrayOfWords)
                .map(a -> a.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect2);

        System.out.println("给定[1, 2, 3, 4, 5]，返回[1, 4, 9, 16, 25]");
        Integer[] nums = {1, 2, 3, 4, 5};
        Stream.of(nums)
                .map(n -> n * n)
                .forEach(System.out::println);

        System.out.println("给定列表[1, 2, 3]和列表[3, 4]，返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]");
        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(3, 4);
        List<int[]> collect = nums1.stream()
                        .flatMap(i -> nums2.stream().map(j -> new int[]{i, j}))
                        .collect(Collectors.toList());
        collect.stream().flatMapToInt(Arrays::stream).forEach(a -> System.out.print(a + "\t"));

        System.out.println("扩展前一个例子，只返回总和能被3整除的数对 例如(2, 4)和(3, 3)");
        Stream<int[]> stream2 = nums1.stream()
                .flatMap(
                        i -> nums2.stream()
                                .filter(j -> (i + j) % 3 == 0)
                                .map(j -> new int[]{i, j})
                );
        stream2.flatMapToInt(Arrays::stream).forEach(a -> System.out.print(a + "\t"));
    }
}