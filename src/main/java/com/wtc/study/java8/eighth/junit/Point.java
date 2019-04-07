package com.wtc.study.java8.eighth.junit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

/**
 * @author 吴天成
 * @create 2019/4/7
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Point {
    private  int x;
    private  int y;

    public Point moveRightBy(int x){
        return new Point(this.x + x, this.y);
    }

    public final static Comparator<Point> compareByXAndThenY =
        Comparator.comparing(Point::getX).thenComparing(Point::getY);
}