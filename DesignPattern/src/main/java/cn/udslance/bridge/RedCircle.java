package cn.udslance.bridge;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-24 20:51
 **/
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
