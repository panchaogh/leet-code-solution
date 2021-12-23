package com.leetcode;

public class ClimbStairs {
    public static void main(String[] args) {
        int climbStairs = new Solution().climbStairs(5);
        System.out.println(climbStairs);
    }

    static class Solution {
        /**
         * 动态规划-递归
         */
        public int climbStairs1(int n) {
            return (n == 0 || n == 1) ? 1 : climbStairs1(n - 2) + climbStairs1(n - 1);
        }

        /**
         * 动态规划-循环迭代
         */
        public int climbStairs(int n) {
            int i = 0, j = 1, k = 1;
            for (int l = 1; l <= n; l++) {
                k = i + j;
                i = j;
                j = k;
            }
            return k;
        }
    }
}
