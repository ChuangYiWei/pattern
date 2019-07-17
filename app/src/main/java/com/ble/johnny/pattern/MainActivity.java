package com.ble.johnny.pattern;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import Chain.Chain;
import Chain.Number;
import Chain.NegativeProcessor;
import Chain.PositiveProcessor;
import Chain.ZeroProcessor;
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
import decorator.FarmHouse;
import decorator.FreshTomato;
import decorator.Margherita;
import decorator.Paneer;
import decorator.Pizza;
import factory.FactoryPatternDemo;
import interator.Iterator_test;
import interator.NameRepository;
import interpret.Context_Test;
import interpret.Expression;
import interpret.ExpressionImplA;
import interpret.ExpressionImplB;
import prototype.Sensor;
import proxy.Internet;
import proxy.ProxyInternet;
import singleton.SingleObject;
import state.AlertStateContext;
import state.Silent;
import stradegy.Context;
import stradegy.OperationAdd;
import stradegy.OperationMultiply;
import template.NetOrder;
import template.OrderProcessTemplate;
import template.StoreOrder;

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


//        compositedemo();
//        prototypedemo();
        //statepedemo();
//        chaindemo();
//        interpreterdemo();
//        decoratordemo();
//        templatedemo();
        proxy_demo();
    }

    void proxy_demo()
    {
        Internet internet = new ProxyInternet();
        try
        {
            internet.connectTo("geeksforgeeks.org");
            internet.connectTo("abc.com");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    void iterator_demo()
    {
        NameRepository namesRepository = new NameRepository();
        Iterator_test iterator = namesRepository.getIterator();
        while(iterator.hasNext())
        {
            System.out.println("Name : " + iterator.next());
        }

    }

    void templatedemo()
    {
        OrderProcessTemplate netOrder = new NetOrder();
        netOrder.processOrder(true);

        OrderProcessTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder(true);
    }

    void decoratordemo()
    {
        // create new margherita pizza
        Pizza pizza = new Margherita();
        System.out.println( pizza.getDescription() +
                " Cost :" + pizza.getCost());
        // create new FarmHouse pizza
        Pizza pizza2 = new FarmHouse();

        // decorate it with freshtomato topping
        pizza2 = new FreshTomato(pizza2);

        //decorate it with paneer topping
        pizza2 = new Paneer(pizza2);

        System.out.println( pizza2.getDescription() +
                " Cost :" + pizza2.getCost());
    }

    void interpreterdemo()
    {

        Context_Test context = new Context_Test("a123 B456");
        Expression expression = null;
        for(String sentence : context.getContext().split(" "))
        {
            String first = sentence.substring(0, 1);
            if(first.matches("[a-z]"))
            {
                expression = new ExpressionImplA();
            }
            else
            {
                expression = new ExpressionImplB();
            }

            /*
             * 會輸出：
             * 246
             * 228
             */
            System.out.println(expression.interpret(sentence));
        }
    }

    void chaindemo()
    {
        //configure Chain of Responsibility
        Chain c1 = new NegativeProcessor();
        Chain c2 = new ZeroProcessor();
        Chain c3 = new PositiveProcessor();
        c1.setNext(c2);
        c2.setNext(c3);

        //calling chain of responsibility
        c1.process(new Number(90));
        c1.process(new Number(-50));
        c1.process(new Number(0));
        c1.process(new Number(91));
    }

    void compositedemo()
    {
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
    void prototypedemo()
    {
        //prototype
        Sensor[] sensors = new Sensor[5];
        sensors[0] = new Sensor();
        sensors[0].setID(1);
        sensors[0].setName("Sensor第一版");
        sensors[0].setNickname("我的空氣探測器");
        sensors[0].setVersion("1.0.0");
        sensors[0].setWifiID("MYSENSORWIFIID1.0.0");
        sensors[0].setWifiPass("THISisWiFiPasssOuO");
        sensors[0].setData("None");

        for(int i = 1 ; i < 5 ; i ++){
            try{
                //all instance clone by sensors[0]
                //need casting
                sensors[i] = (Sensor)sensors[0].clone();
                sensors[i].setID(i+1);
            }catch (CloneNotSupportedException e){
                e.printStackTrace();
            }
        }
        for (int i = 0 ; i < 5 ; i++) {
            Log.d("prototype",sensors[i].getName());
            Log.d("prototype","id:" + sensors[i].getID());
        }
    }



    void statepedemo(){
        AlertStateContext stateContext = new AlertStateContext();
        stateContext.alert();
        stateContext.alert();
        stateContext.setState(new Silent());
        stateContext.alert();
        stateContext.alert();
        stateContext.alert();
    }

    void Stradgeydemo()
    {
        Context ctx = new Context(new OperationAdd());
        //of course we can use set method instead of use new
        Log.d("Stradgeydemo","op add : " + ctx.executeStrategy(1,2));

        ctx = new Context(new OperationMultiply());
        ctx.executeStrategy(1,2);

        Log.d("Stradgeydemo","op multi : " + ctx.executeStrategy(1,2));
    }
}


