package com.jerry.proxy;

import java.lang.reflect.InvocationHandler;

/**
 * Date: 17/9/7 13:40
 *
 * @author jerry.R
 */

public class ProxyMain {
    public static void main(String[] args) {
        Iservice iservice = new IserviceImp();
        InvocationHandler handler = new Proxy(iservice);

        Iservice proxyService = (Iservice) java.lang.reflect.Proxy.newProxyInstance(Iservice.class.getClassLoader(),
                new Class[]{Iservice.class}, handler);
        proxyService.sayHello();


    }

}
