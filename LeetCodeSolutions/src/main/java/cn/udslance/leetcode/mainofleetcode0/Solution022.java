package cn.udslance.leetcode.mainofleetcode0;



import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-06-21 23:28
 */
public class Solution022 {

    public void test() {
        System.out.println(generateParenthesis(4));
    }

    public List<String> generateParenthesis(int n) {
        List<String> strings = new ArrayList<>();

        strings.add("()");

        for (int i = 1; i < n; i++) {
            int size = strings.size();

            for (int j = 0; j < size; j++) {
                String temp = strings.remove(0);
                StringBuilder sb1 = new StringBuilder();
                sb1.append(temp);
                sb1.append("()");
                strings.add(sb1.toString());

                StringBuilder sb2 = new StringBuilder();
                sb2.append("()");
                sb2.append(temp);
                String tmp = sb2.toString();
                if (!strings.contains(tmp)) {
                    strings.add(sb2.toString());
                }


                StringBuilder sb3 = new StringBuilder();
                sb3.append("(");
                sb3.append(temp);
                sb3.append(")");
                strings.add(sb3.toString());

            }
        }

        return strings;


    }

    public void generateParenthesisHelper(List<String> resList, StringBuilder sb, int n, int i) {
        if (i == n) {
            resList.add(sb.toString());
        }

        sb.append("()");

        generateParenthesisHelper(resList, sb, n, i + 1);

        sb.delete(sb.length() - 2, sb.length());


    }
}
