package com.example.observerpattern.customobservable;

import android.util.Log;

import com.example.observerpattern.customobservable.interfaces.ObserverInterface;
import com.example.observerpattern.customobservable.interfaces.SubjectInterface;

public class ObserverObj2 implements ObserverInterface {
    private static final String TAG = ObserverObj2.class.getName();
    private float temp;
    private float humidity;
    private float pressure;
    private SubjectInterface subject;

    public ObserverObj2(SubjectInterface subject) {
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
