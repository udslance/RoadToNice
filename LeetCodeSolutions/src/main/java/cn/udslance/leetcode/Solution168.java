package cn.udslance.leetcode;

/**
 * @title: Excel表列名称
 * @description: 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * @difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/excel-sheet-column-title/description/">link</a>
 * @author: Udslance
 * @create: 2022-11-10 22:16
 **/
class Solution168 {
    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber =columnNumber / 26;
        }
        return sb.reverse().toString();
    }
}
