package com.leetcode.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 时间复杂度 O(nlog2n) log以2为底n的对数
 * 空间复杂度 O(log2n) log以2为底n的对数
 * 不稳定排序算法
 * 适用于顺序存储和链式存储
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,3,7,6,4,1,0,2,9,10,8};
        new QuickSort.Solution().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static class Solution {
        public void sort(int[] arr) {
            sort(arr, 0, arr.length - 1);
        }

        private void sort(int[] arr, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(arr, low, high);
                sort(arr, low, pivotIndex - 1);
                sort(arr, pivotIndex + 1, high);
            }
        }

        private int partition(int[] arr, int low, int high) {
            int pivot = arr[low];
            while (low < high) {
                while (low < high && arr[high] > pivot) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] < pivot) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = pivot;
            return low;
        }

        private int partition1(int[] arr, int low, int high) {
            int pivot = arr[low];
            while (low < high) {
                while (low < high && arr[high] > pivot) {
                    high--;
                }
                swap(arr,low,high);
                while (low < high && arr[low] < pivot) {
                    low++;
                }
                swap(arr,low,high);
            }
            return low;
        }

        private int partition2(int[] arr, int low, int high) {
            int pivot = arr[low];
            while (low < high) {
                while (low < high && arr[high] > pivot) {
                    high--;
                }
                while (low < high && arr[low] < pivot) {
                    low++;
                }
                if (arr[low] == arr[high] && low < high) {
                    low++;
                } else {
                    swap(arr, low, high);
                }
            }
            return low;
        }

        private void swap(int[] arr, int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
