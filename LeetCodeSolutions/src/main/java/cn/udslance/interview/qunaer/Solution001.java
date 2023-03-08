package cn.udslance.interview.qunaer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author H
 * @create 2021-09-14 19:16
 */
class Solution001 {

    /* Write Code Here */

    /**
     * 一个正整数的数组 arr，数组满足0 <= arr[i] <= 9，挑出任意个数组成一个最大的数，并且能被3整除，并以字符串形式返回。
     *
     * @param d
     * @return
     */
    public String solution(int[] d) {
        int length = d.length;
        //对数组进行排序
        Arrays.sort(d);

        int l = 0, r = length - 1;
        while (l < r) {
            int tmp = d[l];
            d[l++] = d[r];
            d[r--] = tmp;
        }

        List<Integer> path = new ArrayList<>();

        for (int i = length; i >= 1 && record == null; i--) {
            dfs(d, 0, 0, i, path);
        }



        if (record == null) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : record) {
            stringBuilder.append(integer);
        }


        return stringBuilder.toString();


    }

    private  List<Integer> record;


    private void dfs(int[] d, int start, int sum, int target, List<Integer> path) {
        if (path.size() == target) {
            if (sum % 3 == 0) {
                record = new ArrayList<>(path);
            }
            return;
        }

        for (int i = start; i < d.length; i++) {
            if (record == null) {
                path.add(d[i]);

                dfs(d, i + 1, sum + d[i], target, path);

                path.remove(path.size() - 1);
            } else {
                break;
            }

        }
    }
}
