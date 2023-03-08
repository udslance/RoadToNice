package cn.udslance.newcode;

import org.junit.jupiter.api.Test;

/**
 * @author: Udslance
 * @create: 2023-02-22 22:09
 **/
class NewCode001 {
    private int maxDrink(int input) {
        return input / 2;
    }

    @Test
    public void test() {
        System.out.println(maxDrink(81));
    }
}
