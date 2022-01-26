package com.leetcode;

/**
 * 01背包问题
 */
public class Knapsack01 {
    public static void main(String[] args) {
        int[] prices = {0, 3, 4, 5, 6};
        int[] capacities = {0, 2, 3, 4, 5};
        int maxPrice = new Solution().maxPriceByRecursive(prices, capacities, 10);
        System.out.println(maxPrice);
    }

    static class Solution {
        public int maxPriceByNonRecursive(int[] prices, int[] capacities, int maxCapacity) {
            int[][] cache = new int[prices.length][maxCapacity + 1];

            for (int i = 1; i < cache.length; i++) {//第i个物品
                for (int j = 1; j < cache[0].length; j++) {//剩余容量
                    if (j < capacities[i]) {
                        cache[i][j] = cache[i - 1][j];
                    } else {
                        cache[i][j] = Math.max(cache[i - 1][j], cache[i - 1][j - capacities[i]] + prices[i]);
                    }
                }
            }

            printCache(cache);

            getGoodList(prices, capacities, maxCapacity, cache);

            return cache[cache.length - 1][cache[0].length - 1];
        }

        public int maxPriceByRecursive(int[] prices, int[] capacities, int maxCapacity) {
            int[][] cache = new int[prices.length][maxCapacity + 1];

            int price = maxPriceByRecursive(cache, prices, capacities, prices.length - 1, maxCapacity);

            printCache(cache);

            getGoodList(prices,capacities,maxCapacity,cache);

            return price;
        }

        public int maxPriceByRecursive(int[][] cache, int[] prices, int[] capacities, int i, int j) {
            if (i == 0 || j == 0) {
                return 0;
            }
            if (cache[i][j] != 0) {
                return cache[i][j];
            }
            if (j < capacities[i]) {
                cache[i][j] = maxPriceByRecursive(cache, prices, capacities, i - 1, j);
            } else {
                cache[i][j] = Math.max(maxPriceByRecursive(cache, prices, capacities, i - 1, j), maxPriceByRecursive(cache, prices, capacities, i - 1, j - capacities[i]) + prices[i]);
            }
            return cache[i][j];
        }

        private void printCache(int[][] cache) {
            for (int[] ints : cache) {
                for (int j = 0; j < cache[0].length; j++) {
                    System.out.print(ints[j] + " ");
                }
                System.out.println();
            }
        }

        private void getGoodList(int[] prices, int[] capacities, int maxCapacity, int[][] cache) {
            //查询选取了哪些物品
            boolean[] goods = new boolean[prices.length];
            for (int i = prices.length - 1; i > 0; i--) {
                if (cache[i][maxCapacity] != cache[i - 1][maxCapacity]) {
                    goods[i] = true;
                    maxCapacity = maxCapacity - capacities[i];
                } else {
                    goods[i] = false;
                }
            }
            for (int i = 1; i < goods.length; i++) {
                System.out.print(goods[i] + " ");
            }
            System.out.println();
        }
    }
}
