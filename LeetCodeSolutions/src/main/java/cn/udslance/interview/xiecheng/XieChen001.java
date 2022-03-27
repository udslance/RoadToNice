package cn.udslance.interview.xiecheng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-09-09 19:02
 */
public class XieChen001 {
    private static final List<String> STRING_LIST = new ArrayList<>();

    static{
        STRING_LIST.add("\\");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < n; i++) {
            String[] cmd = br.readLine().trim().split(" ");
            solution001(cmd);
        }
    }

    public static void solution001(String[] cmd) {
        if ("cd".equals(cmd[0])) {
            if ("..".equals(cmd[1])) {
                if (STRING_LIST.size() > 1) {
                    STRING_LIST.remove(STRING_LIST.size() - 1);
                }
            } else {
                if (STRING_LIST.size() == 1) {
                    STRING_LIST.add(cmd[1]);
                } else {
                    STRING_LIST.add("\\" + cmd[1]);
                }

            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : STRING_LIST) {
                stringBuilder.append(s);
            }
            System.out.println(stringBuilder);
        }
    }
}
