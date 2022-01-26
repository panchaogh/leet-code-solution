package com.leetcode.sort;

import java.util.Arrays;

/**
 * 直接选择排序
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 * 不稳定排序算法
 * 适用于顺序存储和链式存储
 * 时间复杂度与初始序列无关
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {0, 7, 2, 9, 3, 6, 8, 5, 4, 1};
        new SelectSort.Solution().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static class Solution {
        public void sort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[min]) {
                        min = j;
                    }
                }
                if (min != i) {
                    swap(arr, i, min);
                }
            }
        }

        private void swap(int[] arr, int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
