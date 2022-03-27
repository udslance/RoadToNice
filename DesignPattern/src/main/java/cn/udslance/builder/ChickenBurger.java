package cn.udslance.builder;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-22 09:58
 **/
public class ChickenBurger extends Burger{
    @Override
    public String name() {
        return "ChickenBurger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
