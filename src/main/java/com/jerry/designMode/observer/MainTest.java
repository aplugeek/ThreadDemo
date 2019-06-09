package com.jerry.designMode.observer;

/**
 * Date: 2017/10/5 22:50
 *
 * @author jerry.R
 */

public class MainTest {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observer1 = new ObserverImp();
        Observer observer2 = new ObserverImp();
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.setState("hello observers");
    }
}
