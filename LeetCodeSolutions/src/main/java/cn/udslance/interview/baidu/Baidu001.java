package cn.udslance.interview.baidu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author H
 * @create 2021-09-22 19:15
 */
public class Baidu001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        int sum = 0;

        for (int i = 0; i < N; i++) {
            String[] strings = br.readLine().trim().split(" ");
            for (String string : strings) {
                sum += Integer.parseInt(string);
            }
        }

        System.out.println(sum);
    }
}
