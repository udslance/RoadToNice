package cn.udslance.abstract_factory;

/**
 * @author H
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
