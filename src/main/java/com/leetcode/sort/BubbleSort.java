package com.leetcode.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 * 稳定排序算法
 * 适用于顺序存储和链式存储
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {0, 7, 2, 9, 3, 6, 8, 5, 4, 1};
        new BubbleSort.Solution().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static class Solution {
        public void sort(int[] arr) {
            //需要进行n-1趟比较
            for (int i = 0; i < arr.length - 1; i++) {
                //将大数数向右移动
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                    }
                }
            }
        }

        public void sort1(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) { //需要进行n-1趟比较
                //将小数向左移动
                for (int j = arr.length - 1; j > i; j--) {
                    if (arr[j] < arr[j - 1]) {
                        swap(arr, j, j - 1);
                    }
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
