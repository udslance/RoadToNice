package cn.udslance.interview.xiecheng;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
class Solution001 {

    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        int[] input = {1, 2, 3, 4, 5};
        System.out.println(search(input,6));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }


    public int search(int[] input, int target){
        int l = 0, mid = 0, r = input.length - 1;

        while(l < r){
            mid = l + (r - l) / 2;

            if(input[mid] == target){
                return mid;
            }

            if(input[mid] < target){
                //mid 值小于目标值，目标值在mid右边
                l = mid + 1;
            }else{
                //mid 值大于于目标值，目标值在mid左边
                r = mid - 1;
            }
        }
        System.out.println("最后一行");
        return input[l] == target ? l : -1;

    }


}
