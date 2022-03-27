package cn.udslance.command;

/**
 * @program: RoadToNice
 * @description:
 * @author: Udslance
 * @create: 2022-03-27 22:18
 **/
public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
