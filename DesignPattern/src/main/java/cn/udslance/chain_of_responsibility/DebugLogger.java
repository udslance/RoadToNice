package cn.udslance.chain_of_responsibility;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-27 17:02
 **/
public class DebugLogger extends AbstractLogger{
    public DebugLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Debug Console::Logger: " + message);
    }
}
