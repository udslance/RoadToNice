package cn.udslance.builder;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-22 09:56
 **/
public abstract class Burger implements Item{

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
