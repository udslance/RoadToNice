package cn.udslance.prototype;

import java.util.HashMap;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-22 10:42
 **/
public class ShapeCache {
    private static HashMap<String, Shape> shapeHashMap = new HashMap<>();

    public static Shape getShape(String shapeId) {
        Shape cacheShape = shapeHashMap.get(shapeId);
        //关键代码
        return (Shape) cacheShape.clone();
    }

    /**
     * 对每种形状都运行数据库查询，并创建该形状
     * shapeMap.put(shapeKey, shape);
     * 例如，我们要添加三种形状
     */
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeHashMap.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        shapeHashMap.put(rectangle.getId(), rectangle);

        Square square = new Square();
        square.setId("3");
        shapeHashMap.put(square.getId(), square);
    }
}
