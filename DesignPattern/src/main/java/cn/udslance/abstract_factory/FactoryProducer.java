package cn.udslance.abstract_factory;

public class FactoryProducer {

    public static AbstractFactory getFactory(String factoryType){
        if ("Shape".equalsIgnoreCase(factoryType)) {
            return new ShapeFactory();
        } else if ("Color".equalsIgnoreCase(factoryType)) {
            return new ColorFactory();
        }

        return null;

    }
}
