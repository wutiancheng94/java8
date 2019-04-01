package com.wtc.study.java8.lambda.third.demo02;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 〈〉
 *
 * @author 吴天成
 * @create 2019/4/1
 * @since 1.0.0
 */
public interface BufferedReaderProcessor {

    String processFile(BufferedReader bufferedReader) throws IOException;
}