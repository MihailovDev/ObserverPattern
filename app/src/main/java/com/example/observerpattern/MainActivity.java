package com.example.observerpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.observerpattern.customobservable.ObserverObj1;
import com.example.observerpattern.customobservable.ObserverObj2;
import com.example.observerpattern.customobservable.SubjectObj;
import com.example.observerpattern.javaobservable.JavaObserveObj1;
import com.example.observerpattern.javaobservable.JavaObserverObj2;
import com.example.observerpattern.javaobservable.SubjectJava;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Simple custom implementation of ObserverPattern with push method.
        //This uses the PUSH model. The SubjectObj implements a SubjectInterface which
        //allows us to register, remove or notify an Observer. The ObserverObj implements
        //an ObserverInterface that exposes an update method. We use composition and this
        //allows the communication between the Observable and Observer.
        SubjectObj subjectObj = new SubjectObj();
        ObserverObj1 observer1 = new ObserverObj1(subjectObj);
        ObserverObj2 observer2 = new ObserverObj2(subjectObj);
        subjectObj.setMeasurements(12,12,12);
        subjectObj.setMeasurements(30, 30, 30);

        //Simple java.util.Observable implementation
        //This uses the PUSH model (setMeasurements()) and PULL model(update(Observable o)). The drawbacks are that Observable is a class and we
        //have to extend it, this limits the reuse potential. Also, it doesn't implement
        //Observable interface, so we can't create custom implementation that suits the
        //Observer API.
        SubjectJava subjectJava = new SubjectJava();
        JavaObserveObj1 observerObj1 = new JavaObserveObj1(subjectJava);
        JavaObserverObj2 observerObj2 = new JavaObserverObj2(subjectJava);
        subjectJava.setMeasurements(100,100,100);
        subjectJava.setMeasurements(200,200,200);

        //gets the date whenever it needs it.
        observerObj1.update(subjectJava,null);
    }
}
