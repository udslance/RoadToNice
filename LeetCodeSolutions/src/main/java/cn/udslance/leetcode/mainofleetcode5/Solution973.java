package cn.udslance.leetcode.mainofleetcode5;

import java.util.Arrays;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution973 {

    public int[][] kClosest(int[][] points, int k) {
        if (points.length == 1) {
            return points;
        }
        return part(points, k, 0, points.length - 1);
    }

    private int[][] part(int[][] points, int k, int left, int right) {
        int loc = quickSort(points, left, right);

        if (loc == k) {
            return Arrays.copyOfRange(points, 0, k);
        }
        if (loc > k) {
            return part(points, k, left, loc - 1);
        } else {
            return part(points, k, loc + 1, right);
        }
    }

    /**
     * 快排
     * @param points ...
     * @param left ...
     * @param right ...
     * @return ...
     */
    private int quickSort(int[][] points, int left, int right) {
        if (left >= right) {
            return left;
        }
        int l = left, r = right;
        int[] pivot = points[l];
        while (true) {
            while (r > l && (points[r][0] * points[r][0] + points[r][1] * points[r][1]) >= (pivot[0] * pivot[0] + pivot[1] * pivot[1])) {
                r--;
            }
            while (r > l && (points[l][0] * points[l][0] + points[l][1] * points[l][1]) <= (pivot[0] * pivot[0] + pivot[1] * pivot[1])) {
                l++;
            }
            if (r <= l) {
                break;
            }
            int[] tmp = points[l];
            points[l] = points[r];
            points[r] = tmp;
        }
        int[] tmp = points[l];
        points[l] = points[left];
        points[left] = tmp;
        return l;
    }
}
