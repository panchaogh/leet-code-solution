package com.leetcode.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 时间复杂度 O(nlog2n) log以2为底n的对数
 * 空间复杂度 O(n)
 * 稳定排序算法
 * 适用于顺序存储和链式存储
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {0, 7, 2, 9, 3, 6, 8, 5, 4, 1};
        new MergeSort.Solution().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static class Solution {
        public void sort(int[] arr) {
            mergeSort(arr, 0, arr.length - 1);
        }

        private void mergeSort(int[] arr, int low, int high) {
            if (low < high) {
                int mid = low + (high - low) / 2;
                //数组拆分
                mergeSort(arr, low, mid);
                mergeSort(arr, mid + 1, high);
                //两两归并
                merge(arr, low, mid, high);
            }
        }

        private void merge(int[] arr, int low, int mid, int high) {
            //初始化合并数组
            int[] temp = new int[high - low + 1];
            int i = low, j = mid + 1, k = 0;
            while (i <= mid && j <= high) {
                temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
            }

            while (i <= mid) {
                temp[k++] = arr[i++];
            }
            while (j <= high) {
                temp[k++] = arr[j++];
            }

            //将排好序的temp复制到原始数组中
            System.arraycopy(temp, 0, arr, low, temp.length);
        }
    }
}
