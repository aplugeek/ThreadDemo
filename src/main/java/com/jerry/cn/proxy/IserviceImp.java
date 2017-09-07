package com.jerry.cn.proxy;

/**
 * Date: 17/9/7 13:39
 *
 * @author jerry.R
 */

public class IserviceImp implements Iservice {
    @Override
    public void sayHello() {
        System.out.println("hello world!");
    }
}
