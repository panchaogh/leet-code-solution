package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *  杨辉三角
 */
public class Generate {
    public static void main(String[] args) {
        List<List<Integer>> result = new Solution().generate(5);
        System.out.println(result);
    }

    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            if (numRows < 1) return result;
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);
            for (int i = 2; i <= numRows; i++) {
                List<Integer> iRow = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    if (j == 0 || j == i - 1) {
                        iRow.add(1);
                        continue;
                    }
                    List<Integer> lastRow = result.get(i - 2);
                    iRow.add(lastRow.get(j - 1) + lastRow.get(j));
                }
                result.add(iRow);
            }
            return result;
        }
    }
}
