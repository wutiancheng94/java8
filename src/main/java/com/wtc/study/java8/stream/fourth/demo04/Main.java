package com.wtc.study.java8.stream.fourth.demo04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  练习
 * @author 吴天成
 * @create 2019/4/4
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("(1) 找出2011年发生的所有交易，并按交易额排序（从低到高）");
        method1(transactions);

        System.out.println("(2) 交易员都在哪些不同的城市工作过？");
        method2(transactions);

        System.out.println("(3) 查找所有来自于剑桥的交易员，并按姓名排序");
        method3(transactions);

        System.out.println("(4) 返回所有交易员的姓名字符串，按字母顺序排序");
        method4(transactions);

        System.out.println("(5) 有没有交易员是在米兰工作的？");
        method5(transactions);

        System.out.println("(6) 打印生活在剑桥的交易员的所有交易额");
        method6(transactions);

        System.out.println("(7) 所有交易中，最高的交易额是多少？");
        method7(transactions);

        System.out.println("(8) 找到交易额最小的交易");
        method8(transactions);
    }

    private static void method8(List<Transaction> transactions) {
        transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .ifPresent(s -> System.out.println(s));
    }

    private static void method7(List<Transaction> transactions) {
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .ifPresent(s -> System.out.println(s));
    }

    private static void method6(List<Transaction> transactions) {
        transactions.stream()
                .filter(s -> "Cambridge".equals(s.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    private static void method5(List<Transaction> transactions) {
        System.out.println(transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(s -> "Milan".equals(s.getCity())));

    }

    private static void method4(List<Transaction> transactions) {
        String reduce = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(reduce);
    }

    private static void method3(List<Transaction> transactions) {
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(x -> "Cambridge".equals(x.getCity()))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
    }

    private static void method2(List<Transaction> transactions) {
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);

        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .collect(Collectors.toSet());
    }

    private static void method1(List<Transaction> transactions) {
        transactions.stream()
                .filter(r -> r.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
    }
}