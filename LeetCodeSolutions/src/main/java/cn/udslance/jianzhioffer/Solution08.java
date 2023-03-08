package cn.udslance.jianzhioffer;

/**
 * @author H
 * @create 2021-05-12 15:13
 */
class Solution08 {

    public void test() {
        int[] nums = {7,8,4,5,3,1,2,9};
        System.out.println(minNumber(nums));
    }
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs) {
            res.append(s);
        }
        return res.toString();
    }
    void quickSort(String[] strs, int l, int r) {
        if(l >= r) {
            return;
        }
        int i = l, j = r;
        String tmp = strs[i];
        while(i < j) {
            //从右边开始找一个数，“该数 + 左端数” < “左端数 + 该数”
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) {
                j--;
            }
            //从左边开始找一个数，“该数 + 左端数” > “左端数 + 该数”
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) {
                i++;
            }

            //交换找到的两个数，把组合“较小”的数换到左边来。
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        //此时循环结束，i 和 j 指向同一个数，相对 strs[l] 该数左端全是较小数，该数右端全是较大数。
        //将 strs[l] 和 strs[i] 交换。
        strs[i] = strs[l];
        strs[l] = tmp;
        //递归排序
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }
}
