package com.wtc.study.java8.eighth.design.factory.use;

import com.wtc.study.java8.eighth.design.factory.entity.Bond;
import com.wtc.study.java8.eighth.design.factory.entity.Loan;
import com.wtc.study.java8.eighth.design.factory.entity.Product;
import com.wtc.study.java8.eighth.design.factory.entity.Stock;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public class ProductFactoryLambda {
    final static Map<String, Supplier<Product>> map = new HashMap<>();
    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static Product createProduct(String name){
        Supplier<Product> p = map.get(name);
        if(p != null) {
            return p.get();
        }
        throw new IllegalArgumentException("No such product " + name);
    }
}