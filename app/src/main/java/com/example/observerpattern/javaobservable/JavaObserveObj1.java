package com.example.observerpattern.javaobservable;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

public class JavaObserveObj1 implements Observer {
    private final static String TAG = JavaObserveObj1.class.getName();

    private float temp;
    private float humidity;
    private float pressure;
    private Observable observable;

    public JavaObserveObj1(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);


    }

    private void log() {
        Log.i(TAG, "temp => " + temp + " humidity => " + humidity + " pressure => " + pressure);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof SubjectJava){
            SubjectJava subject = (SubjectJava) o;
            this.temp = subject.getTemp();
            this.humidity = subject.getHumidity();
            this.pressure = subject.getPressure();
            log();
        }
    }
}
