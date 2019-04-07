package com.wtc.study.java8.eighth.design.templateMethod.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Integer id;

    private String name;
}