package cn.udslance.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-22 10:03
 **/
public class Meal {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getTotalPrice(){
        float totalPrice = 0.0f;
        for(Item item : items){
            totalPrice += item.price();
        }

        return totalPrice;
    }

    public void showItems(){
        for (Item item : items){
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
}
