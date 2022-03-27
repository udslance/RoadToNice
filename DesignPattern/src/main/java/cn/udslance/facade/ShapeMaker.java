package cn.udslance.facade;

/**
 * @program: DesignPattern
 * @description: 一个外观类。
 * @author: Udslance
 * @create: 2022-03-27 15:41
 **/
public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}

