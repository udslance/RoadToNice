package cn.udslance.flyweight;

import java.util.HashMap;

/**
 * @program: DesignPattern
 * @description: 生成基于给定信息的实体类的对象。
 * @author: Udslance
 * @create: 2022-03-27 15:59
 **/
public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    /**
     * ShapeFactory 检查它的 HashMap 中的 circle 对象，
     * 如果找到 Circle 对象，则返回该对象，否则将创建一个存
     * 储在 hashmap 中以备后续使用的新对象，并把该对象返回
     * 到客户端。
     * @param color
     * @return
     */
    public static Shape getCircle(String color) {
        Circle circle = (Circle)circleMap.get(color);

        if(circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
