package cn.udslance.decorator;

/**
 * @program: DesignPattern
 * @description: 实现了 Shape 接口的抽象装饰类。
 * @author: Udslance
 * @create: 2022-03-27 11:19
 **/
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw(){
        decoratedShape.draw();
    }
}
