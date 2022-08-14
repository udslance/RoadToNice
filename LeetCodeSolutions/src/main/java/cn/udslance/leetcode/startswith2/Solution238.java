package cn.udslance.leetcode.startswith2;



/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution238 {
    
    public void test() {

    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        //维护一个前缀乘积和一个后缀乘积
        int[] pre = new int[len];
        pre[0] = 1;
        for (int i = 1; i < len; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        int[] aft = new int[len];
        aft[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            aft[i] = aft[i + 1] * nums[i + 1];
        }

        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = aft[i] * pre[i];


        }
        return res;
    }
}
