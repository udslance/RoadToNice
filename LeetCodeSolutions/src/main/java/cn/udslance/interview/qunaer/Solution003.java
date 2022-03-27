package cn.udslance.interview.qunaer;


/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution003 {
    /**
     * S[1..3n−2] (n≥2) 是一个半回文当且仅当它满足 S[i]=S[2n−i]=S[2n+i− 2] (1≤i≤n)
     * @param n ...
     * @param str ...
     * @return ...
     */
    public int solution(int n, String str) {
        //char[] tmpChars = str.toCharArray();
        //char[] chars = new char[str.length() + 1];
        //
        //System.arraycopy(tmpChars, 0, chars, 1, chars.length - 1);

        // nb ≥ 2

        //
        int res = 0;
        for (int nb = 2; 3 * nb - 2 <= str.length(); nb++) {
            int windowSize = 3 * nb - 2;
            for (int i = 0; i < str.length() - windowSize; i++) {
                String tmp = str.substring(i,i + windowSize);
                if (helper(tmp, nb)) {
                    ++res;
                }
            }

        }

        return res;
    }

    public boolean helper(String str, int nb) {
        for (int i = 1; i <= nb; i++) {
            int a = i - 1;
            int b = 2 * nb - i - 1;
            int c = 2 * nb + i - 3;
            if (!(str.charAt(a) == str.charAt(b) && str.charAt(a) == str.charAt(c))) {
                return false;
            }
        }
        return true;
    }

    
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        System.out.println(solution(0,"cdcdsdcdscbaabc"));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
