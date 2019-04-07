package com.wtc.study.java8.tenth.demo02;

import com.wtc.study.java8.tenth.demo02.entity.Person2;

import java.util.Optional;

/**
 * 获取值
 *
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public class Demo03 {

    public static void main(String[] args) {

        Optional<Person2> optionalPerson = Optional.ofNullable(new Person2());
        Optional<Object> optional = Optional.empty();

        //1、get()：有则返回，无则抛NoSuchElementException异常
        Person2 person2 = optionalPerson.get();
//        Object object = optional.get();

        //2. Optional对象有值则返回对应的值，不包含值时则提供一个默认值
        Object nullHandle = optional.orElse("hehe");
        System.out.println(nullHandle);

        //3、有值则执行指定操作，无则不执行
        optional.ifPresent(s -> System.out.println("optional"));
        optionalPerson.ifPresent(s -> System.out.println("optionalPerson"));

        // 如果有值则将其返回，否则抛出一个由指定的 Supplier 接口生成的异常
        optionalPerson.orElseThrow(() -> new RuntimeException());
    }
}