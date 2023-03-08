package cn.udslance.leetcode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
class Solution647 {
    
    public void test() {
        System.out.println(countSubstrings("abc"));
    }

    public int countSubstrings(String s) {
        //存放的是当前字符能与之前的字符共同组成的回文串
        List<Integer>[] lists = new List[s.length()];
        for (int i = 0; i < s.length(); i++) {
            lists[i] = new ArrayList<>();
        }
        //初始化
        lists[0].add(0);

        for (int i = 1; i < s.length(); i++) {
            lists[i].add(i);
            List<Integer> lastList = lists[i - 1];
            for (Integer integer : lastList) {
                if (s.charAt(i) == s.charAt(integer)) {
                    lists[i].add(integer);
                }
            }
        }

        int sum = 0;

        for (List<Integer> list : lists) {
            sum += list.size();
        }

        return sum;

    }

    /**
     * 用来判断字符串是不是回文串
     * @param s ...
     * @return ...
     */
    public boolean check(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
