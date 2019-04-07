package com.wtc.study.java8.tenth.demo03;

import java.util.Optional;
import java.util.Properties;

/**
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        System.out.println(readDuration(props, "a"));

        System.out.println("========使用Optional和Stream改造=========");
        System.out.println(readDurationOptional(props, "a"));
    }

    public static int readDuration(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    public static int readDurationOptional(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                    .flatMap(Main::stringToInt)
                    .filter(i -> i > 0)
                    .orElse(0);
    }

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.ofNullable(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}

