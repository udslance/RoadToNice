package cn.udslance.abstract_factory;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");

        Shape shape1 = shapeFactory.getShape("Rectangle");
        
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("Circle");

        shape2.draw();

        Shape shape3 = shapeFactory.getShape("Square");

        shape3.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("color");

        Color color1 = colorFactory.getColor("red");

        color1.fill();

        Color color2 = colorFactory.getColor("blue");

        color2.fill();

        Color color3 = colorFactory.getColor("green");

        color3.fill();
    }
}
