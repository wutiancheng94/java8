package com.wtc.study.java8.stream.seventh.demo01;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

/**
 * 共享可变状态会影响并行流以及并行计算
 * 要避免共享可变状态，确保并行Stream得到正确的结果
 *
 * 使用ParallelStream的注意事项
 *  --并行流并不总是比顺序流快，如果有疑问，测量
 *
 *  --留意装箱。自动装箱和拆箱操作会大大降低性能。
 *    Java 8中有原始类型流（IntStream、LongStream、 DoubleStream）来避免这种操作，但凡有可能都应该用这些流
 *
*   --limit和findFirst等依赖于元素顺序的操作，它们在并行流上执行的代价非常大。
 *
 *  --对于较小的数据量，选择并行流几乎从来都不是一个好的决定
 *
 *  --LinkedList 和 Stream.iterate 不适合并行
 *
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public class Demo02 {

    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, 10_000_000L).parallel().forEach(accumulator::add);
        System.out.println(accumulator.total);

        LongStream.rangeClosed(1, 10_000_000L).parallel().forEach(accumulator::addAtomic);
        System.out.println(accumulator.atomicLong);
    }
}

class Accumulator {
    public long total = 0;

    public AtomicLong atomicLong = new AtomicLong(0);

    //  非原子操作
    public void add(long value) { total += value; }

    public void addAtomic(long value) { atomicLong.addAndGet(value); }

}