package com.jerry.cn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Date: 17/9/7 13:39
 *
 * @author jerry.R
 */

public class Proxy implements InvocationHandler {
    public Object object;

    public Proxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeMethod();
        method.invoke(object, args);
        afterMethod();
        return null;
    }

    private void afterMethod() {
        System.out.println("after method...");
    }


    private void beforeMethod() {
        System.out.println("before method...");
    }
}
