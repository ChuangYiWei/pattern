package com.ble.johnny.pattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import Observer.BinaryObserver;
import Observer.HexaObserver;
import Observer.OctalObserver;
import Observer.Subject;
import factory.FactoryPatternDemo;
import singleton.SingleObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FactoryPatternDemo demo = new FactoryPatternDemo();
        demo.main("aa");

        SingleObject obj = SingleObject.getInstance();
        obj.showMessage();

        Subject subject = new Subject();
        HexaObserver hexobj = new HexaObserver(subject);
        OctalObserver octobj = new OctalObserver(subject);
        BinaryObserver binobj = new BinaryObserver(subject);
        hexobj.Gettest();
        octobj.Gettest();
        binobj.Gettest();

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
