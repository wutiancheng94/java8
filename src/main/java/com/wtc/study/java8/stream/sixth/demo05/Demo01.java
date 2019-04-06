package com.wtc.study.java8.stream.sixth.demo05;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 自定义 Collector 接口
 *
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public class Demo01<T> implements Collector<T, List<T>, List<T>> {

    /**
     * 建立新的结果容器
     * @return
     */
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    /**
     * 将元素添加到结果容器
     * @return
     */
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    /**
     *  合并两个结果容器
     * @return
     */
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (x1, x2) -> {
            x1.addAll(x2);
            return x1;
        };
    }

    /**
     * 对结果容器应用最终转换
     * @return
     */
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
    }
}