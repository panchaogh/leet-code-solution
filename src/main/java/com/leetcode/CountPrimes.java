package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 计数质数
 */
public class CountPrimes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int countPrimes = solution.countPrimes2(10);
        System.out.println(countPrimes);
    }

    static class Solution {
        /**
         * 线性筛
         */
        public int countPrimes2(int n) {
            List<Integer> primes = new ArrayList<>();
            int[] isPrime = new int[n];
            Arrays.fill(isPrime, 1);
            for (int i = 2; i < n; ++i) {
                if (isPrime[i] == 1) {
                    primes.add(i);
                }
                for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                    isPrime[i * primes.get(j)] = 0;
                    if (i % primes.get(j) == 0) {
                        break;
                    }
                }
            }
            return primes.size();
        }

        /**
         * 埃氏筛
         */
        public int countPrimes1(int n) {
            int[] isPrimes = new int[n];
            Arrays.fill(isPrimes, 1);
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (isPrimes[i] == 1) {
                    count++;
                    if ((long) i * i < n) {
                        for (int j = i * i; j < n; j += i) {
                            isPrimes[j] = 0;
                        }
                    }
                }
            }
            return count;
        }

        /**
         * 枚举法
         */
        public int countPrimes(int n) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += isPrime(i) ? 1 : 0;
            }
            return count;
        }

        public boolean isPrime(int n) {
            if (n <= 1) {
                return false;
            }
            double sqrt = Math.sqrt(n);
            for (int i = 2; i <= sqrt; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
