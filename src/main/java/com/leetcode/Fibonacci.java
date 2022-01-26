package com.leetcode;

import java.util.Stack;

/**
 * 斐波那契数列
 */
public class Fibonacci {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long result = solution.fibRecOfMemo(10);
        System.out.println(result);
    }

    static class Solution {

        /**
         * 递归方法实现
         * f(n) = f(n - 1) + f(n - 2)
         * 最高支持 n = 92 ，否则超出 Long.MAX_VALUE
         */
        public long fibRec(int n) {
            if (n < 1) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            return fibRec(n - 1) + fibRec(n - 2);
        }

        /**
         * 递归方法实现(优化)
         * f(n) = f(n - 1) + f(n - 2)
         * 最高支持 n = 92 ，否则超出 Long.MAX_VALUE
         */
        public long fibRecOfMemo(int n) {
            long[] memo = new long[n + 1];
            return fibRecOfMemo(n, memo);
        }

        public long fibRecOfMemo(int n, long[] memo) {
            if (n < 1) {
                memo[0] = 0;
                return memo[0];
            }
            if (n == 1) {
                memo[1] = 1;
                return memo[1];
            }
            memo[n] = fibRecOfMemo(n - 1, memo) + fibRecOfMemo(n - 2, memo);
            return memo[n];
        }

        /**
         * 平推方法实现
         * 最高支持 n = 92 ，否则超出 Long.MAX_VALUE
         */
        public long fibLoopOfMemo(int n) {
            if (n < 1 || n > 92) {
                return 0;
            }
            long[] memo = new long[n + 1];
            memo[0] = 0;
            memo[1] = 1;
            for (int i = 2; i <= n; i++) {
                memo[i] = memo[i - 1] + memo[i - 2];
            }
            return memo[n];
        }

        /**
         * 平推方法实现(优化)
         * 最高支持 n = 92 ，否则超出 Long.MAX_VALUE
         */
        public long fibLoop(int n) {
            if (n < 1 || n > 92) {
                return 0;
            }
            long a = 0;
            long b = 1;
            long temp;
            for (int i = 2; i <= n; i++) {
                temp = a;
                a = b;
                b += temp;
            }
            return b;
        }

        /**
         * 栈方法实现
         * 最高支持 n = 92 ，否则超出 Long.MAX_VALUE
         */
        public long fibStack(int n) {
            long sum = 0;
            Stack<Long> stack = new Stack<>();
            long a = 0;
            long b = 0;
            stack.push((long) n);
            while (!stack.empty()) {
                Long pop = stack.pop();
                if (pop == 0) {
                    sum += 0;
                }
                if (pop == 1) {
                    sum += 1;
                }
                if (pop > 1) {
                    stack.push(pop - 1);
                    stack.push(pop - 2);
                }
            }
            return sum;
        }
    }
}
