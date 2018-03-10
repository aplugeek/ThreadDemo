package com.jerry.reflect;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Date: 2018/3/10 19:43
 *
 * @author jerry.R
 */

public class Main {
    public static void main(String[] args) throws Exception {
        User user = new User();
        Class<?> clazz = User.class;
        String name = "name";
        PropertyDescriptor descriptor = new PropertyDescriptor(name,clazz);
        Method method = descriptor.getWriteMethod();
        method.invoke(user, "jerry");
        System.out.println(user.getName());
    }
}
