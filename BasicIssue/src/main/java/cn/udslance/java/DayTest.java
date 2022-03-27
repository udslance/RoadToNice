package cn.udslance.java;

import java.util.Scanner;

public class DayTest {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Day day01 = new Day();
        getDay(day01);
        System.out.println(day01);
    }

    public static void getDay(Day dayA){
        System.out.println("please type in day");
        int d = SCANNER.nextInt();
        System.out.println("please type in month");
        int m = SCANNER.nextInt();
        System.out.println("please type in year");
        int y = SCANNER.nextInt();

        dayA.day = d;
        dayA.month = m;
        dayA.year = y;

        System.out.println(dayA);
    }
}
