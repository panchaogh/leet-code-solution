package com.leetcode;

/**
 * 位1的个数(也被称为汉明重量)
 */
public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(0x55555555);
        System.out.println(0x33333333);
        System.out.println(0x0f0f0f0f);
        int result = new Solution().hammingWeight2(156);
        System.out.println(result);
    }

    static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) != 0) count++;
            }
            return count;
        }

        public int hammingWeight1(int n) {
            int count = 0;
            while (n != 0) {
                n &= n - 1;
                count++;
            }
            return count;
        }

        public int hammingWeight2(int n) {
            return Integer.bitCount(n);
        }
    }
}
