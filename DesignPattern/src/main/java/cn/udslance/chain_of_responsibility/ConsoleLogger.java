package cn.udslance.chain_of_responsibility;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-27 17:00
 **/
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
