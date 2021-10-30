package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int repeatNumber = new FindRepeatNumber().findRepeatNumber(arr);
        System.out.println(repeatNumber);
    }
}
