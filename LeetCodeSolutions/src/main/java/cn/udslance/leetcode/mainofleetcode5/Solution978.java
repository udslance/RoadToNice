package cn.udslance.leetcode.mainofleetcode5;



/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution978 {
    public int maxTurbulenceSize(int[] arr) {
        int res = 1;
        //期待升
        int up = 1;
        int down = 1;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > arr[i - 1]) {
                //升
                //down：在上轮迭代中下降，在本轮得到上升，变成 up
                //down 重置为 1 防止下次紧接着再次发生上升
                up = down + 1;
                down = 1;
                res = Math.max(res, up);
            } else if (arr[i] < arr[i - 1]) {
                //降
                //up：在上轮迭代中上升，在本轮得到下降，变成 down
                //up：重置为 1 防止下次紧接着再次发生下降
                down = up + 1;
                up = 1;
                res = Math.max(res, down);
            } else {
                //平
                //up 和 down 全部置 1 从头再来
                down = 1;
                up = 1;
            }
        }
        return res;
    }
    
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        int[] arr = new int[]{1,4,2,10,7,8,8,1,9};
        System.out.println(maxTurbulenceSize(arr));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
