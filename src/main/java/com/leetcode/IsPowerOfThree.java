package com.leetcode;

/**
 * 3的幂
 */
public class IsPowerOfThree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfThree(-3));
    }

    static class Solution {
        public boolean isPowerOfThree(int n) {
            while (n != 0 && n % 3 == 0) {
                n /= 3;
            }
            return n == 1;
        }

        public boolean isPowerOfThree1(int n) {
            return n > 0 && 1162261467 % n == 0;
        }
    }
}
