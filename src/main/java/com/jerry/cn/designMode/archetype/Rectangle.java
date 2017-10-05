package com.jerry.cn.designMode.archetype;

/**
 * Date: 17/9/1 16:56
 *
 * @author jerry.R
 */

public class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    void draw() {
        System.out.println("this is draw() method ");
    }
}
