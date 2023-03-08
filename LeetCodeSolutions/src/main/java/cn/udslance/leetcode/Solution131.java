package cn.udslance.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-07-26 19:29
 */
class Solution131 {
    
    public void test() {
        List<List<String>> res = partition("aabb");

        for (List<String> re : res) {
            System.out.println(re);
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(s, 0, s.length(), path, res);
        return res;
    }

    private void dfs(String s, int start, int end, List<String> path, List<List<String>> res) {
        if (start == end) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start + 1; i < s.length() + 1; i++) {
            if (!isPalindrome(s.substring(start, i))) {
                //不是回文串，直接下一位
                continue;
            }
            path.add(s.substring(start, i));
            dfs(s, i, end, path, res);
            path.remove(path.size() - 1);
        }

    }

    /**
     * 判断字符串是否为回文字符串
     *
     * @param str 字符串
     * @return true: 是回文字符串
     */
    private boolean isPalindrome(String str) {
        if (str.length() == 0) {
            return true;
        }
        int i = 0, j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
