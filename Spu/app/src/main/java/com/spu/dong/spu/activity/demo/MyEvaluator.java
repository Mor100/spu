package com.spu.dong.spu.activity.demo;

import android.animation.TypeEvaluator;

import com.spu.dong.spu.activity.model.Point;

public class MyEvaluator implements TypeEvaluator<Point> {


    @Override
    public Point evaluate(float v, Point point, Point t1) {

        Point point1 = new Point(0,0);
        //设置值为 系数乘以差值
        point1.setX(point.getX()+v*(t1.getX()-point.getX()));
        //设置值为 系数乘以差值
        point1.setY(point.getY()+v*(t1.getY()-point.getY()));

        return point1;
    }
}
