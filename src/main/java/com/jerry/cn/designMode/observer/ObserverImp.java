package com.jerry.cn.designMode.observer;

/**
 * Date: 2017/10/5 22:48
 *
 * @author jerry.R
 */

public class ObserverImp  extends Observer {
    private Subject subject;
    public ObserverImp(Subject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }

    @Override
    void updateNotify() {
        System.out.println("ObserverImp get update notify....updateValue: "+subject.getState());
    }
}
