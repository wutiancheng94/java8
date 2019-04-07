package com.wtc.study.java8.tenth.demo02;

import com.wtc.study.java8.tenth.demo02.entity.Car;
import com.wtc.study.java8.tenth.demo02.entity.Insurance;
import com.wtc.study.java8.tenth.demo02.entity.Person;

import java.util.Optional;


/**
 * 使用 map 从 Optional 对象中提取和转换值
 *
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public class Demo02 {

    public static void main(String[] args) {
        Insurance insurance = new Insurance();
        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optionalInsurance.map(Insurance::getName);

        Optional<Person> personOptional = Optional.ofNullable(new Person());
        System.out.println(getCarInsuranceName(personOptional));

        Optional<Car> carOptional = Optional.ofNullable(new Car());

    }

    private static String getCarInsuranceName(Optional<Person> personOptional) {

        return personOptional
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

}