package com.example.observerpattern.customobservable;

import com.example.observerpattern.customobservable.interfaces.ObserverInterface;
import com.example.observerpattern.customobservable.interfaces.SubjectInterface;

import java.util.ArrayList;

public class SubjectObj implements SubjectInterface {
    ArrayList<ObserverInterface> observers;
    private float temp;
    private float humidity;
    private float pressure;


    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public SubjectObj() {
        observers = new ArrayList<>();
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    @Override
    public void registerReceiver(ObserverInterface observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ObserverInterface observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        for (ObserverInterface observer : observers) {
            observer.update(temp, humidity, pressure);
        }
    }
    private void measurementsChanged() {
        notifyObserver();
    }

}
