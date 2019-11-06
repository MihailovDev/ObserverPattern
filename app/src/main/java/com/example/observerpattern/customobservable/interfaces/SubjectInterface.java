package com.example.observerpattern.customobservable.interfaces;

public interface SubjectInterface {
    void registerReceiver(ObserverInterface observer);
    void removeObserver(ObserverInterface observer);
    void notifyObserver();
}
