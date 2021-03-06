package cn.udslance.facade;

/**
 * @program: DesignPattern
 * @description: 使用该外观类画出各种类型的形状。
 * @author: Udslance
 * @create: 2022-03-27 15:41
 **/
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}

