package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 缺失数字
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, 1};
        int result = new Solution().missingNumber3(nums);
        System.out.println(result);
    }

    static class Solution {
        /**
         * 排序
         */
        public int missingNumber(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }
            return nums.length;
        }

        /**
         * 哈希
         */
        public int missingNumber1(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, num);
            }
            for (int i = 0; i <= nums.length; i++) {
                if (!map.containsKey(i)) {
                    return i;
                }
            }
            return 0;
        }

        /**
         * 位运算
         */
        public int missingNumber2(int[] nums) {
            int result = 0;
            for (int num : nums) {
                result ^= num;
            }
            for (int i = 0; i <= nums.length; i++) {
                result ^= i;
            }
            return result;
        }

        /**
         * 数学
         */
        public int missingNumber3(int[] nums) {
            int n = nums.length;
            int total = n * (n + 1) / 2;
            int sum = 0;
            for (int num: nums) {
                sum += num;
            }
            return total-sum;
        }

    }
}
