package cn.udslance.newcode;

import java.util.Scanner;

/**
 * @title:
 * @description:
 * @difficulty:
 * @Link: <a href="">...</a>
 * @author: Udslance
 * @create: 2023-02-22 22:47
 **/
class NewCode003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        String hex = "0xfff";
        Integer x = Integer.parseInt(str.substring(2),16);//从第2个字符开始截取
        System.out.println(x);
    }
}
