package cn.udslance.abstract_factory;

public class ShapeFactory extends AbstractFactory{

    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }

        if("Rectangle".equalsIgnoreCase(shapeType)){
            return new Rectangle();
        }else if("Square".equalsIgnoreCase(shapeType)){
            return new Square();
        }else if("Circle".equalsIgnoreCase(shapeType)){
            return new Circle();
        }
        return null;
    }
    @Override
    public Color getColor(String color) {
        return null;
    }
}
