package cn.udslance.proxy;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-27 16:33
 **/
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        System.out.println("第一次调用，图像将从磁盘加载");
        image.display();
        System.out.println("第二次调用，图像不需要从磁盘加载");
        // 图像不需要从磁盘加载
        image.display();
    }
}
