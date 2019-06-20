package com.ble.johnny.pattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import Observer.BinaryObserver;
import Observer.HexaObserver;
import Observer.OctalObserver;
import Observer.Subject;
import bridge.Assemble;
import bridge.Bike;
import bridge.Car;
import bridge.Produce;
import bridge.Vehicle;
import builder.McFood;
import composite.Employee;
import factory.FactoryPatternDemo;
import singleton.SingleObject;

import static builder.McFood.Drink.DRINK_COLA;
import static builder.McFood.Hamburg.HAMBURG_BEEF;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FactoryPatternDemo demo = new FactoryPatternDemo();
        demo.main("aa");

        SingleObject obj = SingleObject.getInstance();
        obj.showMessage();

        //observer
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

        //builder
        McFood food = new McFood.Builder()
                .drink(new McFood.Drink(DRINK_COLA))
                .addIce(false)  //去冰
                .hamburg(new McFood.Hamburg(HAMBURG_BEEF))  //牛肉汉堡
                .takeOut(true)  //外带
                .totalCount(3)  //总共*3
                .create();
        //bridge
        Vehicle vehicle1 = new Car(new Produce(), new Assemble());
        vehicle1.manufacture();
        Vehicle vehicle2 = new Bike(new Produce(), new Assemble());
        vehicle2.manufacture();

        //composite
        Employee CEO = new Employee("John","CEO", 30000);

        Employee headSales = new Employee("Robert","Head Sales", 20000);

        Employee headMarketing = new Employee("Michel","Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        //打印该组织的所有员工

        Log.w("composite",CEO.toString());
        for (Employee headEmployee : CEO.getSubordinates()) {
            Log.d("composite",headEmployee.toString());
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }
}
