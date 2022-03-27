package cn.udslance.jianzhioffer;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author H
 * @create 2021-05-21 14:28
 */
public class SecSolution {

    
    public void test() {
        int[] nums = {3, 30, 34, 5, 9};

        System.out.println(minNumber(nums));

    }

    public String minNumber(int[] nums) {
        //特殊情况
        if (nums.length == 0) {
            return null;
        }

        //转成字符串数组比较好处理
        String[] strings = new String[nums.length];

        for (int i = 0; i < strings.length; i++) {
            strings[i] = "" + nums[i];
        }

        quickSort(strings, 0, strings.length - 1);

        StringBuilder stringBuilder = new StringBuilder();

        for (String string : strings) {
            stringBuilder.append(string);
        }

        return stringBuilder.toString();
    }

    public void quickSort(String[] strings, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int i = lo, j = hi;
        String strV = strings[lo];

        while (i < j) {

            while (i <= hi && (strings[i] + strV).compareTo(strV + strings[i]) < 0) {
                i++;
            }

            while (j >= lo && (strings[j] + strV).compareTo(strV + strings[j]) > 0) {
                j--;
            }

            if (i >= j) {
                break;
            }

            String tmp = strings[i];

            strings[i] = strings[j];

            strings[j] = tmp;
        }

        strings[lo] = strings[j];

        strings[j] = strV;

        if (lo < j) {
            quickSort(strings, lo, j);
        }

        if (hi > i) {
            quickSort(strings, i, hi);
        }
    }

    
    public void test2() {
        int[] ints1 = {3, 4, 5, 2, 1, 7, 3, 4, 7};
        int[] ints2 = {1, 2, 4, 1, 2, 5, 1, 2, 6};

        Arrays.sort(ints1);
        Arrays.sort(ints2);


        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(ints2));

    }

    
    public void test4() {
        int[][] res = findContinuousSequence(15);

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }



    public int[][] findContinuousSequence(int target) {
        int[] ints = new int[target / 2 + 2];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }

        List<int[]> res1 = new ArrayList<>();

        int i = 1, j = 1;

        while (i < ints.length && j < ints.length) {
            int sum = (ints[i] + ints[j]) * (j - i + 1) / 2;

            if (sum == target) {
                res1.add(Arrays.copyOfRange(ints, i, j + 1));
                i++;
            } else if (sum > target) {
                i++;
            } else if (sum < target) {
                j++;
            }
        }

        int[][] res2 = new int[res1.size()][];

        for (int k = 0; k < res1.size(); k++) {
            res2[k] = res1.get(k);
        }


        return res2;
    }

    public double[] dicesProbability(int n){
        int[][] helper = new int[n + 1][6 * n + 1];

        //初始化第一行，只有一颗骰子的时候，全是 1
        for (int i = 1; i <= 6; i++) {
            helper[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= j && k <= 6; k++) {
                    helper[i][j] += helper[i - 1][j - k];
                }
            }
        }

        double[] ans = new double[6 * n - n + 1];

        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = ((double) helper[n][i]) / Math.pow(6, n);
        }

        return ans;
    }

    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return a;
        }

        int[] left = new int[a.length];
        int[] right = new int[a.length];

        int[] res = new int[a.length];

        left[0] = 1;
        right[right.length - 1] = 1;

        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }

        for (int i = left.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }

        return res;

    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            int num1 = nums1[i - 1];
            for (int j = 1; j <= n; j++) {
                int num2 = nums2[j - 1];

                if (num1 == num2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public int strToInt2(String str) {
        char[] c = str.trim().toCharArray();

        if (c.length == 0) {
            return 0;
        }

        int res = 0, bndry = Integer.MAX_VALUE / 10;

        //i：作为遍历起点
        //sign：作为正负标记
        int i = 1, sign = 1;

        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+') {
            i = 0;
        }

        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') {
                break;
            }

            //越界判断
            if (res > bndry || res == bndry && c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + (c[j] - '0');
        }

        return sign * res;





    }

}
