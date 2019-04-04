package com.wtc.study.java8.stream.fifth.demo03;

import com.wtc.study.java8.stream.fourth.demo01.Dish;
import com.wtc.study.java8.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 数值流
 *  IntStream、 DoubleStream和 LongStream，分别将流中的元素特化为int、 long和double，避免装箱成本。
 *
 *  数值范围
 *  IntStream和LongStream的静态方法，可以生成数值范围
 *
 * @author 吴天成
 * @create 2019/4/4
 * @since 1.0.0
 */
public class Demo01 {

    public static void main(String[] args) {
        List<Dish> dishs = ListUtils.getDishs();

        System.out.println("映射到数值流");
        method1(dishs);

        System.out.println("转换回对象流");
        method2(dishs);

        System.out.println("数值范围");
        System.out.print("生成1~5(不含)的数:");
        IntStream.range(1, 5).forEach(System.out::print);

        System.out.print("\n生成1~5的数:共");
        System.out.println(IntStream.rangeClosed(1, 5).count() + "个数");

        System.out.println("列出1~100内前5个勾股数，如3,4,5");
        IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a ->
                    IntStream.rangeClosed(a, 100)
                            .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                            .boxed()
                            .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}))
//                等同于上面2句
//                            .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}))
                .limit(5)
                .forEach(s -> System.out.println(s[0] + "," + s[1] + "," + s[2]));

        System.out.println("上述方法要求两次平方根。进行优化，可以生成所有的三元数，然后再筛选符合条件的");
        IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                            .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                            .filter(c -> c[2] % 1 == 0))
                .limit(5)
                .forEach(s -> System.out.println(s[0] + "," + s[1] + "," + s[2]));
    }

    private static void method2(List<Dish> dishs) {
        IntStream intStream = dishs.stream().mapToInt(Dish::getCalories);
        Stream<Integer> boxed = intStream.boxed();
        System.out.println("求和：" + boxed.reduce(0, (x, y) -> x+y));
    }

    private static void method1(List<Dish> dishs) {
        //是IntStream而不是Stream<T>
        IntStream intStream = dishs.stream().mapToInt(Dish::getCalories);
        System.out.println("对menu中的热量sum:" + intStream.sum());

        OptionalInt max = dishs.stream().mapToInt(Dish::getCalories).max();
        max.ifPresent(s -> System.out.println("menu中max的热量：" + s));
        System.out.println("没有最大值的话，则定义一个默认值:" + max.orElse(100));

        OptionalDouble average = dishs.stream().mapToInt(Dish::getCalories).average();
        average.ifPresent(s -> System.out.println("menu中average热量：" + s));

        OptionalInt min = dishs.stream().mapToInt(Dish::getCalories).min();
        min.ifPresent(s -> System.out.println("menu中min的热量：" + s));

        dishs = new ArrayList<>();
        System.out.println("如果流是空的， sum默认返回0:" + dishs.stream().mapToInt(Dish::getCalories).sum());
    }
}