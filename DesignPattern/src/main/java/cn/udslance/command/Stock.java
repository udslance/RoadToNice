package cn.udslance.command;

/**
 * @program: RoadToNice
 * @description:
 * @author: Udslance
 * @create: 2022-03-27 22:17
 **/
public class Stock {

    private String name = "ABC";
    private int quantity = 10;

    public void buy(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
    }
    public void sell(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
    }
}