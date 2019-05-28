package AbstractFactory;

import factory.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println(" Inside factory.Rectangle::draw() method. ");
    }
}

