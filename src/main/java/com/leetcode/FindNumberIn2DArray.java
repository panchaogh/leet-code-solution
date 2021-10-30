package com.leetcode;

public class FindNumberIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target = 31;
        System.out.println(new FindNumberIn2DArray().findNumberIn2DArray(matrix, target));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }
        final int row = matrix.length;
        final int col = matrix[0].length;
        int i = 0;
        int j = col - 1;
        for (; i < row && j >= 0; ) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
