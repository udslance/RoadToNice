package cn.udslance.leetcode.mainofleetcode4;



import java.util.Arrays;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution406 {
    
    public void test() {
        int[][] ints = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(ints);
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(person1,person2)->{
            if (person1[0] == person2[0]){
                return person1[1]-person2[1];
            }else {
                return person2[0]-person1[0];
            }
        });

        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            if (people[i][1]>=i){
                res[i] = people[i];
            }else {
                int target = people[i][1];
                for (int j = i; j > target; j--) {
                    res[j] = res[j-1];
                }
                res[target] = people[i];
            }
        }
        return res;
    }
}
