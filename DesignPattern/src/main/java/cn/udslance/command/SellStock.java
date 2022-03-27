package cn.udslance.command;

/**
 * @program: RoadToNice
 * @description:
 * @author: Udslance
 * @create: 2022-03-27 22:18
 **/
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}
