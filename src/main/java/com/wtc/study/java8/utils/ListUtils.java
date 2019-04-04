package com.wtc.study.java8.utils;

import com.wtc.study.java8.lambda.second.demo01.Apple;
import com.wtc.study.java8.stream.fourth.demo01.Dish;
import com.wtc.study.java8.stream.fourth.demo01.Type;
import com.wtc.study.java8.stream.fifth.demo02.Trader;
import com.wtc.study.java8.stream.fifth.demo02.Transaction;

import java.util.Arrays;
import java.util.List;

/**
 * @author 吴天成
 * @create 2019/3/31
 * @since 1.0.0
 */
public class ListUtils {

    public static List<Apple> getApples() {

        return  Arrays.asList(
                new Apple("green", 100),
                new Apple("green", 180),
                new Apple("green", 200),
                new Apple("red", 100),
                new Apple("red", 180),
                new Apple("red", 200));
    }

    public static List<Dish> getDishs() {
        return Arrays.asList(
                new Dish("pork", false, 800, Type.MEAT),
                new Dish("beef", false, 700, Type.MEAT),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("season fruit", true, 120, Type.OTHER),
                new Dish("pizza", true, 550, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("salmon", false, 450, Type.FISH) );
    }

    public static List<Transaction> getTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));
    }
}