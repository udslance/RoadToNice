package cn.udslance.newcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: Udslance
 * @create: 2023-02-22 22:09
 **/
class NewCode002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            int a = in.nextInt();
            numSet.add(a);
        }
        List<Integer> numList = new ArrayList<>(numSet);
        Collections.sort(numList);
        for (Integer integer : numList) {
            System.out.println(integer);
        }
    }

    private int maxDrink(int input) {
        return input / 2;
    }

    @Test
    public void test() {
        System.out.println(maxDrink(81));
    }
}
