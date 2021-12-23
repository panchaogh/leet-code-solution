package com.leetcode;

/**
 * 121. 买卖股票的最佳时机
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int result = new Solution().maxProfit(prices);
        System.out.println(result);
    }

    static class Solution {
        /**
         * 暴力
         */
        public int maxProfit1(int[] prices) {
            int profit = 0;
            for (int i = 0; i < prices.length; i++) {
                for (int j = i; j < prices.length; j++) {
                    if (prices[i] > prices[j]) continue;
                    profit = Math.max(profit, prices[j] - prices[i]);
                }
            }
            return profit;
        }

        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for (int price : prices) {
                if (price < minPrice) {
                    minPrice = price;
                } else {
                    maxProfit = Math.max(maxProfit, price - minPrice);
                }
            }
            return maxProfit;
        }
    }
}
