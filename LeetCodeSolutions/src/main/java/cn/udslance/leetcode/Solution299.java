package cn.udslance.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
class Solution299 {
    public String getHint(String secret, String guess) {
        //首先统计有多少个奶牛
        // 数字以及数量
        int[] sList = new int[10];
        // Map<位置,数字>
        Map<Integer, Integer> sMap = new HashMap<>();
        int A = 0, B = 0;
        for (int i = 0; i < secret.length(); i++) {
            int temp = Integer.parseInt(secret.substring(i,i + 1));
            sList[temp]++;
            sMap.put(i,temp);
        }
        for (int i = 0; i < guess.length(); i++) {
            int temp = Integer.parseInt(guess.substring(i,i + 1));
            //猜对了数字
            if(sList[temp] > 0){
                B++;
                sList[temp]--;
            }
            //猜对了数字和位置
            if (sMap.get(i) == temp) {
                sMap.remove(i);
                B--;
                A++;
            }
        }
        return A + "A" + B + "B";
    }
    
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        System.out.println(getHint("1123","0111"));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
