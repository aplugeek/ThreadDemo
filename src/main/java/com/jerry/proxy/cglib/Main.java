package com.jerry.proxy.cglib;

import com.jerry.proxy.Iservice;
import com.jerry.proxy.IserviceImp;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * Date: 2019-05-03 10:09
 *
 * @author jerry.R
 */

public class Main {
    public static void main(String[] args) {
        Iservice iservice = new IserviceImp();
        MethodInterceptor interceptor = new CglibProxy(iservice);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(IserviceImp.class);
        enhancer.setCallback(interceptor);
        Iservice proxy = (Iservice) enhancer.create();
        proxy.sayHello();
    }
}
