package cn.udslance.leetcode;

/**
 * @title: Excel 表列序号
 * @description: 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 * @difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/excel-sheet-column-number/description/?orderBy=most_votes">link</a>
 * @author: Udslance
 * @create: 2022-11-10 22:19
 **/
class Solution171 {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }
}
