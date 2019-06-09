package com.jerry.designMode.observer;

/**
 * Date: 2017/10/5 22:48
 *
 * @author jerry.R
 */

public class ObserverImp  extends Observer {
    @Override
    void updateNotify(String value) {
        System.out.println("ObserverImp get update notify....updateValue: "+value);
    }
}
