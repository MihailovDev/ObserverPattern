package com.example.observerpattern.customobservable;

import android.util.Log;

import com.example.observerpattern.customobservable.interfaces.ObserverInterface;
import com.example.observerpattern.customobservable.interfaces.SubjectInterface;

public class ObserverObj1 implements ObserverInterface {
    private final static String TAG = ObserverObj1.class.getName();

    private float temp;
    private float humidity;
    private float pressure;
    private SubjectInterface subject;

    public ObserverObj1(SubjectInterface subject) {
        this.subject = subject;
        subject.registerReceiver(this);
    }

    private void log() {
        Log.i(TAG, "temp => " + temp + " humidity => " + humidity + " pressure => " + pressure);
    }


    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        log();
    }
}
