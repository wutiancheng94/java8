package com.wtc.study.java8.design.strategy.nonuseLambda;

import lombok.Data;

/**
 * 3、一个或多个使用策略对象的客户
 *
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
@Data
public class Validator {

    private ValidationStrategy validationStrategy;

    public Validator(ValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public boolean validate(String s){
        return validationStrategy.execute(s);
    }
}