package cn.udslance.chain_of_responsibility;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-27 17:01
 **/
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
