package cn.udslance.builder;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-22 09:54
 **/
public class Bottle implements Packing{
    @Override
    public String pack() {
        return "Bottle";
    }
}
