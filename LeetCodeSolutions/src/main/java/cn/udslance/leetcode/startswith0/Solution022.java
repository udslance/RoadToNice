package cn.udslance.leetcode.startswith0;



import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-06-21 23:28
 */
public class Solution022 {

    public void test() {
        System.out.println(generateParenthesis(4));
    }

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String curStr) {
        // 左右括号都不剩余了，递归终止
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }
        // 如果左括号还剩余的话，可以拼接左括号
        if (left > 0) {
            dfs(left - 1, right, curStr + "(");
        }
        // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
        if (right > left) {
            dfs(left, right - 1, curStr + ")");
        }
    }
}
