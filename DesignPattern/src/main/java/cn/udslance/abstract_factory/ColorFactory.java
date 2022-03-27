package cn.udslance.abstract_factory;

public class ColorFactory extends AbstractFactory{

    @Override
    public Shape getShape(String shapeType){
        return null;
    }
    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }

        if("Blue".equalsIgnoreCase(color)){
            return new Blue();
        }else if("Red".equalsIgnoreCase(color)){
            return new Red();
        }else if("Green".equalsIgnoreCase(color)){
            return new Green();
        }
        return null;
    }
}
