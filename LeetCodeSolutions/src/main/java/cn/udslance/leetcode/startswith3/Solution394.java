package cn.udslance.leetcode.startswith3;



import java.util.LinkedList;


/**
 * 字符串解码
 * https://leetcode-cn.com/problems/decode-string/submissions/
 *
 * @author H
 * @create 2021-08-12 22:07
 */
public class Solution394 {


    public void test() {
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }

    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        StringBuilder multi = new StringBuilder();
        LinkedList<Integer> stackMulti = new LinkedList<>();
        LinkedList<String> stackRes = new LinkedList<>();

        for (char aChar : chars) {

            if (aChar == '[') {
                stackMulti.add(Integer.parseInt(multi.toString()));
                multi = new StringBuilder();
                stackRes.add(res.toString());
                res = new StringBuilder();
                continue;
            }

            if (aChar == ']') {
                int repeat = stackMulti.removeLast() - 1;
                String repStr = res.toString();

                for (int i = 0; i < repeat; i++) {
                    res.append(repStr);
                }

                res.insert(0, stackRes.removeLast());
                continue;
            }


            if (aChar >= '0' && aChar <= '9') {
                multi.append(aChar);
            } else {
                res.append(aChar);
            }

        }


        return res.toString();
    }
}
