package cn.udslance.decorator;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-27 11:18
 **/
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
