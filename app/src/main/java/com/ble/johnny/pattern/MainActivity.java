package com.ble.johnny.pattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import factory.FactoryPatternDemo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FactoryPatternDemo demo = new FactoryPatternDemo();
        demo.main("aa");
    }
}
