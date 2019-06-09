package com.jerry.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Date: 2019-05-03 10:02
 *
 * @author jerry.R
 */

public class CglibProxy implements MethodInterceptor {
    private Object targetObject;

    public CglibProxy(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object object = null;
        System.out.println("before method invoke");
        object = method.invoke(targetObject, args);
        System.out.println("before method invoke");
        return object;
    }
}
