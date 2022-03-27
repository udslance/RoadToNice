package cn.udslance.java;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;


/**
 * @author H
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        System.out.println("hello world");
    }
    @Test
    public void test01() {
        LocalDateTime rightNow = LocalDateTime.now();

        System.out.println("现在的时间是：" + rightNow);
        System.out.println("现在的年份是：" + rightNow.getYear());
        System.out.println("现在的月份是：" + rightNow.getMonth());
        System.out.println("现在的星期是：" + rightNow.getDayOfWeek());
    }

    @Test
    public void test02(){
        LocalDateTime before = LocalDateTime.of(1997, Month.APRIL,27,19,56);

        System.out.println(before);
    }

    @Test
    public void test03(){
        LocalDateTime rightNow = LocalDateTime.now();
        String now = rightNow.format(DateTimeFormatter.ofPattern("yyyy$MM$dd"));
        System.out.println(now);
    }
}
