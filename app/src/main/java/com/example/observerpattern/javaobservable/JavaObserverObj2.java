package com.example.observerpattern.javaobservable;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

public class JavaObserverObj2 implements Observer {
    private static final String TAG = JavaObserverObj2.class.getName();
    private float temp;
    private float humidity;
    private float pressure;
    private Observable observable;

    public JavaObserverObj2(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }


    private void log() {
        Log.i(TAG, "temp => " + temp + " humidity => " + humidity + " pressure => " + pressure);

    }


    @Override
    public void update(Observable o, Object arg) {
        //pull method
        //This way the Observable doesn't have to push the data all the time, instead, the
        //Observer will check for the data it needs, whenever it needs to. Also, this makes
        //things easier to modify later. For example, if more state is added we don't need to
        // change every "update()".
        if (o instanceof SubjectJava){
            SubjectJava subject = (SubjectJava) o;
            this.temp = subject.getTemp();
            this.humidity = subject.getHumidity();
            this.pressure = subject.getPressure();
            log();
        }
    }
}
