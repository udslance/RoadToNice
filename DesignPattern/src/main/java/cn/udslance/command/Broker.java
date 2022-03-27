package cn.udslance.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: RoadToNice
 * @description: 命令真正的收集者和执行者
 * @author: Udslance
 * @create: 2022-03-27 22:20
 **/
public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
