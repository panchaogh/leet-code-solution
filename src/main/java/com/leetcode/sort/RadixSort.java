package com.leetcode.sort;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Queue;

/**
 * 基数排序
 * 时间复杂度 O(d(n+r))
 * 空间复杂度 O(r)
 * 稳定排序算法
 * 不基于比较进行排序，是根据分配和收集对关键字进行排序的
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {0, 7, 2, 9, 111, 3, 6, 8, 5, 4, 1, 15};
        new RadixSort.Solution().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static class Solution {
        public void sort(int[] arr) {
//            sortByLSD(arr);
            sortByMSD(arr);
        }

        /**
         * 计算待排序数据最大的位数
         */
        public int maxDigits(int[] arr) {
            int max = arr[0];
            for (int num : arr) {
                max = Math.max(max, num);
            }
            int maxDigits = 0;
            while (max != 0) {
                max = max / 10;
                maxDigits++;
            }
            return maxDigits;
        }

        /**
         * 最低位优先排序
         */
        public void sortByLSD(int[] arr) {
            Queue<Integer>[] queues = new Queue[10];
            //初始化队列
            for (int i = 0; i < queues.length; i++) {
                queues[i] = new ArrayDeque<>();
            }
            //计算待排序数据最大的位数
            int digits = maxDigits(arr);
            for (int i = 1; i <= digits; i++) {
                //分配
                for (int k : arr) {
                    queues[k / (int) Math.pow(10, i - 1) % 10].offer(k);
                }
                //收集
                int arrIndex = 0;
                for (Queue<Integer> queue : queues) {
                    Integer num = queue.poll();
                    while (!Objects.isNull(num)) {
                        arr[arrIndex++] = num;
                        num = queue.poll();
                    }
                }
            }
        }

        /**
         * 最高位优先排序
         * 最高位优先(Most Significant Digit first)法，简称MSD法：先按k1排序分组，同一组中记录，关键码k1相等，
         * 再对各组按k2排序分成子组，之后，对后面的关键码继续这样的排序分组，直到按最次位关键码kd对各子组排序后。
         * 再将各组连接起来，便得到一个有序序列。
         */
        public void sortByMSD(int[] arr) {
            //计算待排序数据最大的位数
            int digits = maxDigits(arr);
            sortByMSD(arr, digits);
        }

        /**
         * 最高位优先排序
         * 最高位优先(Most Significant Digit first)法，简称MSD法：先按k1排序分组，同一组中记录，关键码k1相等，
         * 再对各组按k2排序分成子组，之后，对后面的关键码继续这样的排序分组，直到按最次位关键码kd对各子组排序后。
         * 再将各组连接起来，便得到一个有序序列。
         */
        public int[] sortByMSD(int[] arr, int maxDigits) {
            if (maxDigits > 0) {
                Queue<Integer>[] queues = new Queue[10];
                //初始化队列
                for (int i = 0; i < queues.length; i++) {
                    queues[i] = new ArrayDeque<>();
                }
                //分配
                for (int k : arr) {
                    queues[k / (int) Math.pow(10, maxDigits - 1) % 10].offer(k);
                }
                //收集
                int arrIndex = 0;
                for (Queue<Integer> queue : queues) {
                    int[] queueArr = new int[queue.size()];
                    Integer num = queue.poll();
                    int queueArrIndex = 0;
                    while (!Objects.isNull(num)) {
                        queueArr[queueArrIndex++] = num;
                        num = queue.poll();
                    }
                    int[] res = sortByMSD(queueArr, maxDigits - 1);
                    for (int re : res) {
                        arr[arrIndex++] = re;
                    }
                }
            }
            return arr;
        }
    }
}
