package com.leetcode.sort;

import java.util.Arrays;

/**
 * 折半插入排序
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 * 稳定排序算法
 * 折半查找只是减少了比较次数，但是元素的移动次数不变，所以时间复杂度为O(n^2)是正确的！
 * 由于用到了数组下标进行折半，所以适用于顺序存储，不适用于链式存储
 */
public class BinaryInsertionSort {
    public static void main(String[] args) {
        int[] arr = {0, 7, 2, 9, 3, 6, 8, 5, 4, 1};
        new BinaryInsertionSort.Solution().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static class Solution {
        public void sort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int temp = arr[i];
                int low = 0, high = i - 1;
                while (low <= high) {
                    int middle = low + (high - low) / 2;
                    if (temp < arr[middle]) {
                        high = middle - 1;
                    } else {
                        low = middle + 1;
                    }
                }

                for (int j = i - 1; j > high; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[high + 1] = temp;
            }
        }
    }
}
