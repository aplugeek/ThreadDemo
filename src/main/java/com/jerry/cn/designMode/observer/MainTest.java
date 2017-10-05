package com.jerry.cn.designMode.observer;

/**
 * Date: 2017/10/5 22:50
 *
 * @author jerry.R
 */

public class MainTest {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new ObserverImp(subject);//引用传递  修改指向的堆区
        subject.setState(100);
    }
}
