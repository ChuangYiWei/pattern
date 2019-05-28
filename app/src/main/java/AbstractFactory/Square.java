package AbstractFactory;

import factory.Shape;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println(" Inside factory.Square::draw() method. ");
    }
}