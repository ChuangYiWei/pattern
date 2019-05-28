package factory;

public class FactoryPatternDemo {
    public void main(String a) {
       ShapeFactory shapeFactory = new ShapeFactory();

        //获取 factory.Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //调用 factory.Circle 的 draw 方法
        shape1.draw();

        //获取 factory.Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //调用 factory.Rectangle 的 draw 方法
        shape2.draw();

        //获取 factory.Square 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //调用 factory.Square 的 draw 方法
        shape3.draw();
    }
}
