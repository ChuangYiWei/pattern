package AbstractFactory;

import factory.Shape;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println(" Inside factory.Circle::draw() method. ");
    }
}