package com.leetcode;

import java.util.Arrays;

/**
 * 银行家算法
 */
public class BankerAlgorithm {
    private final int[][] max;     // 最大需求矩阵
    private final int[][] allocation;  // 已分配矩阵
    private final int[][] need;    // 需求矩阵
    private final int[] available;  // 可用资源向量
    private final boolean[] finished; // 进程完成标记

    public BankerAlgorithm(int[][] max, int[][] allocation, int[] available) {
        this.max = max;
        this.allocation = allocation;
        this.available = available;

        int processCount = max.length;
        int resourceCount = available.length;

        this.need = new int[processCount][resourceCount];
        this.finished = new boolean[processCount];

        // 计算需求矩阵
        for (int i = 0; i < processCount; i++) {
            for (int j = 0; j < resourceCount; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }
    }

    public boolean isSafe() {
        int processCount = max.length;
        int resourceCount = available.length;

        int[] work = Arrays.copyOf(available, resourceCount);
        boolean[] finish = Arrays.copyOf(finished, processCount);

        int count = 0;
        int[] safeSequence = new int[processCount];

        while (count < processCount) {
            boolean found = false;

            for (int i = 0; i < processCount; i++) {
                if (!finish[i] && hasEnoughResources(need[i], work)) {
                    // 分配资源
                    for (int j = 0; j < resourceCount; j++) {
                        work[j] += allocation[i][j];
                    }

                    safeSequence[count] = i;
                    finish[i] = true;
                    count++;
                    found = true;
                }
            }

            if (!found) {
                break;  // 未找到符合条件的进程
            }
        }

        return count == processCount;
    }

    private boolean hasEnoughResources(int[] request, int[] work) {
        int resourceCount = request.length;

        for (int i = 0; i < resourceCount; i++) {
            if (request[i] > work[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] max = {
                {7, 5, 3},
                {3, 2, 2},
                {9, 0, 2},
                {2, 2, 2},
                {4, 3, 3}
        };

        int[][] allocation = {
                {0, 1, 0},
                {2, 0, 0},
                {3, 0, 2},
                {2, 1, 1},
                {0, 0, 2}
        };

        int[] available = {3, 3, 2};

        BankerAlgorithm bankerAlgorithm = new BankerAlgorithm(max, allocation, available);
        boolean isSafe = bankerAlgorithm.isSafe();
        System.out.println("Is the system in a safe state? " + isSafe);
    }
}
