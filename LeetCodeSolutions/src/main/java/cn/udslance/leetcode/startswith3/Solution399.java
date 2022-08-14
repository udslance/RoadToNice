package cn.udslance.leetcode.startswith3;



import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution399 {
    
    public void test() {

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //map用来检索字符串的坐标
        Map<String, Integer> map = new HashMap<>();
        int index = 0;

        for (List<String> equation : equations) {
            for (String s : equation) {
                if (!map.containsKey(s)) {
                    map.put(s, index++);
                }
            }
        }
        double[][] doubles = new double[map.size()][map.size()];

        for (double[] aDouble : doubles) {
            Arrays.fill(aDouble, -1);
        }

        for (int k = 0; k < equations.size(); k++) {
            List<String> strings = equations.get(k);

            //行
            int i = map.get(strings.get(0));
            //列
            int j = map.get(strings.get(1));
            //值
            double val = values[k];

            doubles[i][j] = val;

            doubles[j][i] = 1 / val;

            if (i - 1 >= 0 && j - 1 >= 0 && doubles[i - 1][j - 1] != -1.0) {
                doubles[i - 1][j] = doubles[i][j] * doubles[i - 1][j - 1];
                doubles[j][i - 1] = 1 / doubles[i - 1][j];
            }

            if (i - 1 >= 0 && j - 1 >= 0 && doubles[j - 1][i - 1] != -1.0) {
                doubles[j - 1][i] = doubles[j][i] * doubles[j - 1][i - 1];
                doubles[i][j - 1] = 1 / doubles[j - 1][i];
            }

        }
        double[] res = new double[queries.size()];
        index = 0;
        for (List<String> query : queries) {

            if (map.containsKey(query.get(0)) && map.containsKey(query.get(1))) {
                if (query.get(0).equals(query.get(1))) {
                    res[index++] = 1;
                    continue;
                }
                int i = map.get(query.get(0));
                int j = map.get(query.get(1));
                res[index++] = doubles[i][j];
            } else {
                res[index++] = -1;
            }


        }


        for (double[] aDouble : doubles) {
            System.out.println(Arrays.toString(aDouble));

        }

        return res;
    }

}
