package com.wtc.study.java8.stream.fourth.demo01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 吴天成
 * @create 2019/4/1
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    /**
     * 菜名
     */
    private String name;

    /**
     * 是素菜吗
     */
    private Boolean vegetarian;

    /**
     * 卡路里（热量）
     */
    private Integer calories;

    private Type type;
}