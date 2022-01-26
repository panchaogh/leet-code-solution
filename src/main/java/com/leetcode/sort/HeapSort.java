package com.leetcode.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 时间复杂度 O(nlog2n) log以2为底n的对数
 * 空间复杂度 O(1)
 * 不稳定排序算法
 * 适用于顺序存储和链式存储
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {0, 7, 2, 9, 3, 6, 8, 5, 4, 1};
        new HeapSort.Solution().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static class Solution {
        public void sort(int[] arr) {
            //构建最大堆
            buildMaxHeap(arr);
            //开始排序逻辑
            for (int i = arr.length - 1; i > 0; i--) {
                //元素交换,作用是去掉大顶堆
                // 把大顶堆的根元素，放到数组的最后；换句话说，就是每一次的堆调整之后，都会有一个元素到达自己的最终位置
                swap(arr, 0, i);
                //调整堆
                // 元素交换之后，毫无疑问，最后一个元素无需再考虑排序问题了。
                // 接下来我们需要排序的，就是已经去掉了部分元素的堆了，这也是为什么此方法放在循环里的原因
                // 而这里，实质上是自上而下，自左向右进行调整的
                adjustHeap(arr, 0, i);
            }
        }

        public void buildMaxHeap(int[] arr) {
            //这里元素的索引是从0开始的,所以最后一个非叶子结点array.length/2 - 1
            //从最后一个非叶子节点开始调整，最后一个非叶子节点为 arr.length/2 - 1
            for (int i = arr.length / 2 - 1; i >= 0; i--) {
                adjustHeap(arr, i, arr.length); //调整堆
            }
        }

        public void adjustHeap(int[] arr, int nodeIndex, int length) {
            //调整堆，自上而下，自左向右进行调整的
            //大根堆使用数组表示规律：若节点下标为k,则左子树下标为2k+1,右子树下标为2k+1+1
            for (int i = 2 * nodeIndex + 1; i < length; i = 2 * i + 1) {
                if (i + 1 < length && arr[i] < arr[i + 1]) {
                    i++;
                }
                if (arr[i] > arr[nodeIndex]) {
                    swap(arr, i, nodeIndex);
                    nodeIndex = i;
                } else { //不用交换，直接终止循环
                    break;
                }
            }
        }

        public void swap(int[] arr, int index1, int index2) {
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
    }
}
