package cn.udslance.interview.huawei;

import java.util.Scanner;

/**
 * 最高分是多少
 * 5 7 第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目 学生ID编号从1编到N
 * 1 2 3 4 5 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’）和两个正整数A,B,
 * 当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 * Q 1 5
 * U 3 6
 * Q 3 4
 * Q 4 5
 * U 4 5
 * U 2 9
 * Q 1 5
 *
 * @author H
 * @create 2021-08-22 15:43
 */
public class HWSolution01 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        //读取第一行
        String line1 = SCANNER.nextLine();
        String[] line1s = line1.split(" ");
        //学生的数目
        int n = Integer.parseInt(line1s[0]);
        //操作的数目
        int m = Integer.parseInt(line1s[1]);
        //读取第二行：包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
        String line2 = SCANNER.nextLine();
        String[] gradeString = line2.split(" ");

        int[] grades = new int[n];

        for (int i = 0; i < n; i++) {
            grades[i] = Integer.parseInt(gradeString[i]);
        }

        for (int i = 0; i < m; i++) {
            //读取操作命令
            String command = SCANNER.nextLine();
            String[] lineX = command.split(" ");
            int a = Integer.parseInt(lineX[1]);
            int b = Integer.parseInt(lineX[2]);

            if (command.startsWith("Q")) {
                maxGrade(grades, a, b);
            }

            if (command.startsWith("U")) {
                grades[a - 1] = b;
            }
        }
    }

    private static void maxGrade(int[] grades, int a, int b) {
        int max = grades[a - 1];

        for (int i = a; i < b; i++) {
            max = Math.max(grades[i], max);
        }

        System.out.println(max);


    }

}
