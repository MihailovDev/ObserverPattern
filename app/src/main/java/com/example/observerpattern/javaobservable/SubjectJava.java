package com.example.observerpattern.javaobservable;

import java.util.Observable;

public class SubjectJava extends Observable {
    private float temp;
    private float humidity;
    private float pressure;

    public SubjectJava() {

    }

    private void measurementsChanged() {
        setChanged(); // notify that the state has changed
        notifyObservers(); // data is not sent, we are using PULL model
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
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
}
