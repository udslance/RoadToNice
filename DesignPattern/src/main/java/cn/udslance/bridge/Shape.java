package cn.udslance.bridge;

/**
 * @program: DesignPattern
 * @description: 使用 DrawAPI 接口创建抽象类 Shape。
 * @author: Udslance
 * @create: 2022-03-24 20:52
 **/
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
