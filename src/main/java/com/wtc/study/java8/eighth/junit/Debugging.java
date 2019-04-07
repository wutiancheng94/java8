package com.wtc.study.java8.eighth.junit;

import java.util.Arrays;
import java.util.List;

/**
 * 由于Lambda表达式没有名字，它的栈跟踪可能很难分析
 * 第一个例子中，由于Lambda表达式没有名字，所以编译器只能为它们指定一个名字
 * 第二个例子中，即使使用了方法引用，还是有可能出现栈无法显示使用的方法名的情况
 * 第三个例子中，如果方法引用指向的是同一个类中声明的方法，那么它的名称是可以在栈跟踪中显示的
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public class Debugging {

    public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(12, 2), null);

//        points.stream().map(p -> p.getX()).forEach(System.out::println);

//        points.stream().map(Point::getX).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 3);
        numbers.stream().map(Debugging::divideByZero).forEach(System.out::println);
    }

    public static int divideByZero(int n){
        return n / 0;
    }
}