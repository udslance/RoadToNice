package cn.udslance.leetcode.startswith1;


/**
 * 比较版本号
 * https://leetcode-cn.com/problems/compare-version-numbers/
 * @author H
 * @create 2021-08-03 19:50
 */
public class Solution165 {

    public void test() {
        String version1 ="1.0.1";
        String version2 ="1";

        System.out.println(compareVersion(version1, version2));
    }

    public int compareVersion(String version1, String version2) {
        String[] v1Break = version1.split("\\.");

        String[] v2Break = version2.split("\\.");

        for (int i = 0, j = 0; i < v1Break.length || j < v2Break.length; i++, j++) {
            int temp1 = i < v1Break.length ? Integer.parseInt(v1Break[i]) : 0;
            int temp2 = j < v2Break.length ? Integer.parseInt(v2Break[j]) : 0;

            if (temp1 > temp2) {
                return 1;
            }

            if (temp1 < temp2) {
                return -1;
            }
        }

        return 0;
    }
}
