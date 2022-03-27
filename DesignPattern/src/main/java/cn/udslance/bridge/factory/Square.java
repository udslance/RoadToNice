package cn.udslance.bridge.factory;

/**
 * @author H
 */
public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
