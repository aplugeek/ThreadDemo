package com.jerry.test;

import java.util.Random;

/**
 * Date: 2018/8/22 23:34
 *
 * @author jerry.R
 */



class Test1{
    public static final int x = new Random().nextInt(100);
    static {
        System.out.println("Test1 initiliazed");
    }
}
class Test2 extends  Test1{
    static {
        System.out.println("Test1 initiliazed");
    }
}
public class Test {
    public static void main(String[] args) {
        System.out.println(Test2.x);
    }

}
