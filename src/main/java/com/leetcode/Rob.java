package com.leetcode;

import java.util.Objects;

/**
 * 打家劫舍
 */
public class Rob {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
//        int[] nums = {1};
        int result = new Solution().rob(nums);
        System.out.println(result);
    }

    static class Solution {
        /**
         * 状态转移方程：rob(n) = Max(rob(n-2)+n,rob(n-1))
         */
        public int rob(int[] nums) {
            if (Objects.isNull(nums) || nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            int beforeMaxAmount = nums[0];
            int afterMaxAmount = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                int temp = afterMaxAmount;
                afterMaxAmount = Math.max(beforeMaxAmount + nums[i], afterMaxAmount);
                beforeMaxAmount = temp;
            }
            return afterMaxAmount;
        }
    }
}
