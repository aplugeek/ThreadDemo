package com.jerry.designMode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2017/10/5 22:41
 *
 * @author jerry.R
 */

public class Subject {
    private int state;
    private List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer observer) {
        this.observerList.add(observer);

    }

    public void setState(int value) {
        this.state = value;
        notifyAllObserver();

    }
    public  String getState(){
        return String.valueOf(state);
    }

    private void notifyAllObserver() {
        for (Observer observer:observerList){
             observer.updateNotify();
        }
    }
}
