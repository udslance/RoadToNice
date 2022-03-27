package cn.udslance.decorator;

/**
 * @program: DesignPattern
 * @description: 扩展了 ShapeDecorator 类的实体装饰类。
 * @author: Udslance
 * @create: 2022-03-27 11:20
 **/
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
