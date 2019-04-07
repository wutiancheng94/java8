package com.wtc.study.java8.tenth.demo01;

/**
 * 判空
 *
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        getCarInsuranceName(new Person());
    }

    public static String getCarInsuranceName(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "Unknown";
    }
}