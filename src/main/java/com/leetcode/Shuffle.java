package com.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * 打乱数组
 */
public class Shuffle {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{-6, 10, 184});
        int[] shuffle = solution.shuffle();
        System.out.println(Arrays.toString(shuffle));
        int[] reset = solution.reset();
        System.out.println(Arrays.toString(reset));
        shuffle = solution.shuffle();
        System.out.println(Arrays.toString(shuffle));
        reset = solution.reset();
        System.out.println(Arrays.toString(reset));
        reset = solution.reset();
        System.out.println(Arrays.toString(reset));
        shuffle = solution.shuffle();
        System.out.println(Arrays.toString(shuffle));
        shuffle = solution.shuffle();
        System.out.println(Arrays.toString(shuffle));
        shuffle = solution.shuffle();
        System.out.println(Arrays.toString(shuffle));
    }

    static class Solution {
        private final int[] originNums;
        private final int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
            this.originNums = new int[nums.length];
            System.arraycopy(nums, 0, originNums, 0, nums.length);
        }

        public int[] reset() {
            System.arraycopy(originNums, 0, nums, 0, nums.length);
            return nums;
        }

        public int[] shuffle() {
            Random random = new Random();
            for (int i = 0; i < nums.length; i++) {
                int index = i + random.nextInt(nums.length - i);
                swap(nums, i, index);
            }
            return nums;
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
