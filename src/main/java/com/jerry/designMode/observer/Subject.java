package com.jerry.designMode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2017/10/5 22:41
 *
 * @author jerry.R
 */

public class Subject {
    private String state;
    private List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer observer) {
        this.observerList.add(observer);

    }

    public void setState(String value) {
        this.state = value;
        notifyAllObserver(value);

    }

    public String getState() {
        return String.valueOf(state);
    }

    private void notifyAllObserver(String value) {
        for (Observer observer : observerList) {
            observer.updateNotify(value);
        }
    }
}
