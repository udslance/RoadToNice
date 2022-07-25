package cn.udslance.ilearningx;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @program: RoadToNice
 * @description: 给定 m 个字符串，请计算有哪些字符在所有字符串中都出现过 n 次及以上。
 * @author: Udslance
 * @create: 2022-07-13 16:09
 **/
public class ilearningx03 {
    public static void main(String[] args) {
        //Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        //int nValue = cin.nextInt();
        //int mValue = cin.nextInt();
        //cin.nextLine();
        //String[] strings = new String[mValue];
        //for (int i = 0; i < mValue; i++) {
        //    strings[i] = cin.nextLine();
        //}
        //cin.close();

        String[] strings1 = new String[]{"aabbccFFFFx2x2","aaccddFFFFx2x2","aabcdFFFFx2x2"};

        char[] results = getNTimesCharacter(2, strings1);

        System.out.print("[");
        for (int i = 0; i < results.length; i++) {
            if (i == 0) {
                System.out.print(results[i]);
            } else {
                System.out.print(" " + results[i]);
            }
        }
        System.out.print("]");
    }

    // 待实现函数，在此函数中填入答题代码
    //升序
    private static char[] getNTimesCharacter(int nValue, String[] strings) {
        Set<Character> characterSet = new HashSet<>();
        Map<Character, Integer> counter = new HashMap<>();

        for (int j = 0; j < strings.length; j++) {
            Set<Character> tmpSet = new HashSet<>();
            counter.clear();
            for (int i = 0; i < strings[j].length(); i++) {
                char tmpChar = strings[j].charAt(i);
                counter.put(tmpChar, counter.getOrDefault(tmpChar, 0) + 1);
                if (counter.get(tmpChar) >= nValue) {
                    tmpSet.add(tmpChar);
                }
            }

            if (j == 0) {
                characterSet.addAll(tmpSet);
            } else {
                characterSet.retainAll(tmpSet);
            }
        }

        char[] result = new char[characterSet.size()];
        int i = 0;

        for (Character character : characterSet) {
            result[i++] = character;
        }


        Arrays.sort(result);

        return result;
    }

    @Test
    public void test01() {
        String[] strings = new String[]{"aabbccFFFFx2x2","aaccddFFFFx2x2","aabcdFFFFx2x2"};

    }
}
