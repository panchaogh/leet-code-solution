package com.leetcode.sort;

import java.util.Arrays;

/**
 * 插入排序-希尔排序（又称缩小增量排序）
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 * 不稳定排序算法
 * 由于使用数组下标对数组进行分组，所以适用于顺序存储，不适用于链式存储
 */
public class ShellsSort {
    public static void main(String[] args) {
        int[] arr = {0, 7, 2, 9, 3, 6, 8, 5, 4, 1};
        new ShellsSort.Solution().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static class Solution {
        public void sort(int[] arr) {
            //缩小增量，起始增量为数组长度的一半，增量每次缩减一半
            for (int stepLength = arr.length / 2; stepLength >= 1; stepLength /= 2) {
                //根据增量进行分组，分别对每一组进行直接插入排序
                for (int group = 0; group < stepLength; group++) {
                    //直接插入排序
                    for (int i = stepLength + group; i < arr.length; i += stepLength) {
                        int temp = arr[i];
                        int j;
                        for (j = i - stepLength; j >= 0 && temp < arr[j]; j -= stepLength) {
                            arr[j + stepLength] = arr[j];
                        }
                        arr[j + stepLength] = temp;
                    }
                }
            }
        }

        public void sort1(int[] arr) {
            for (int stepLength = arr.length / 2; stepLength >= 1; stepLength /= 2) {
                for (int i = stepLength; i < arr.length; i++) {
                    int temp = arr[i];
                    int j;
                    for (j = i - stepLength; j >= 0 && temp < arr[j]; j -= stepLength) {
                        arr[j + stepLength] = arr[j];
                    }
                    arr[j + stepLength] = temp;
                }
            }
        }
    }
}
