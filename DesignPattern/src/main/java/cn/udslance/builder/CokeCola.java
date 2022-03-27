package cn.udslance.builder;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-22 10:00
 **/
public class CokeCola extends ColdDrink{
    @Override
    public String name() {
        return "CokeCola";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
