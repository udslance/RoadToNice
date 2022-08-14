package cn.udslance.leetcode.startswith0;


/**
 * @author H
 * @create 2021-07-01 22:34
 */
public class Solution045 {
    int min = Integer.MAX_VALUE;

    
    public void test() {
        int[] nums = new int[]{2,3,1,1,4};

        int res = jump(nums);

        System.out.println(res);
    }

    public int jump(int[] nums) {


        int ans = 0;
        int start = 0;
        int end = 1;

        while (end < nums.length) {
            //记录从这个start能跳到的最远的位置
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                //能跳到的最远的距离
                maxPos = Math.max(maxPos, i + nums[i]);


            }
            //下一次起跳范围开始的格子
            start = end;
            //下一次起跳范围结束的格子
            end = maxPos + 1;

            ans++;
        }

        return ans;
    }

    public int jump2(int[] nums) {


        int ans = 0;
        int end = 0;
        int maxPos = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(i + nums[i], maxPos);

            if (i == end) {
                end = maxPos;
                ans++;
            }
        }

        return ans;
    }
}
