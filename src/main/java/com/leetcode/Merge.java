package com.leetcode;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 */
public class Merge {
    public static void main(String[] args) {
        int[] num1 = new int[]{0};
        int[] num2 = new int[]{1};
        new Solution().merge(num1, 0, num2, 1);
        System.out.println(Arrays.toString(num1));
    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1, j = n - 1, k = m + n - 1;
            while (i >= 0 && j >= 0) {
                nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
            }
            if (i < 0) System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
    }
}
