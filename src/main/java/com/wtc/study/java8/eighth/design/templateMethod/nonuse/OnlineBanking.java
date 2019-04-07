package com.wtc.study.java8.eighth.design.templateMethod.nonuse;

import com.wtc.study.java8.eighth.design.templateMethod.entity.Customer;
import com.wtc.study.java8.eighth.design.templateMethod.entity.Database;

/**
 * 在线银行应用
 *
 * 用户需要输入一个用户账户，之后应用才能从银行的数据库中得到用户的详细信息，最终完成一些让用户满意的操作。
 * 不同分行的在线银行应用让客户满意的方式可能还略有不同，
 * 比如给客户的账户发放红利，或者仅仅是少发送一些推广文件。
 *
 * @author 吴天成
 * @create 2019/4/6
 * @since 1.0.0
 */
public abstract class OnlineBanking {

    /**
     * 获取客户提供的ID，然后提供服务让用户满意
     * @param id
     */
    public void processCustomer(int id){
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    abstract void makeCustomerHappy(Customer c);
}