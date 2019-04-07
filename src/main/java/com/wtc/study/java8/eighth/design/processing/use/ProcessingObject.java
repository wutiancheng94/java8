package com.wtc.study.java8.eighth.design.processing.use;

/**
 * 责任链模式:一个处理对象可能需要在完成一些工作之后，将结果传递给另一个对象，
 *          这个对象接着做一些工作，再转交给下一个处理对象，以此类推
 *
 * 创建两个处理对象，它们的功能是进行一些文本处理工作，比如头文件处理和拼写检查
 *
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
public abstract class ProcessingObject<T> {

    protected ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input){
        T r = handleWork(input);
        if(successor != null){
            return successor.handle(r);
        }
        return r;
    }

    protected abstract T handleWork(T input);
}