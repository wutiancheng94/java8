package com.wtc.study.java8.eighth.design.factory.nonuse;

import com.wtc.study.java8.eighth.design.factory.entity.Bond;
import com.wtc.study.java8.eighth.design.factory.entity.Loan;
import com.wtc.study.java8.eighth.design.factory.entity.Product;
import com.wtc.study.java8.eighth.design.factory.entity.Stock;

/**
 *  金融产品工厂
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public class ProductFactory {

    private ProductFactory() {
    }

    public static Product createProduct(String name){
        switch(name){
            case "loan": return new Loan();
            case "stock": return new Stock();
            case "bond": return new Bond();
            default: throw new RuntimeException("No such product " + name);
        }
    }
}