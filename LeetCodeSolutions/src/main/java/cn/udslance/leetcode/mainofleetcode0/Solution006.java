package cn.udslance.leetcode.mainofleetcode0;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @Title: Z 字形变换
 * @Difficulty: middle
 * @Link: <a href="https://leetcode.cn/problems/zigzag-conversion/">...</a>
 * @author H
 * @create 2021-08-23 9:21
 *
 */
public class Solution006 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 构建numRows个桶子
        ArrayList<Character> buckets[] = new ArrayList[numRows];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        // 判断当前是向下还是向上
        boolean isGoDown = true;
        // 往哪个桶子里面放字母
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            buckets[index].add(cur);
            if (isGoDown) {
                //判断能否继续向下
                if (index < numRows - 1) {
                    index += 1;
                } else {
                    index -= 1;
                    isGoDown = false;
                }
            } else {
                //判断能否继续向上
                if (index > 0) {
                    index -= 1;
                } else {
                    index += 1;
                    isGoDown = true;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (ArrayList<Character> bucket : buckets) {
            for (Character character : bucket) {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        String string = "AB";
        int numRows = 1;
        System.out.println(convert(string,numRows));

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
