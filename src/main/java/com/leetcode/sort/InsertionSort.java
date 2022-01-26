package com.leetcode.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 * 稳定排序算法
 * 适用于顺序存储和链式存储
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {0, 7, 2, 9, 3, 6, 8, 5, 4, 1};
        new Solution().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static class Solution {
        public void sort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }
        }
    }
}
