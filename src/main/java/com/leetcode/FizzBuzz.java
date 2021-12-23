package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz
 */
public class FizzBuzz {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.fizzBuzz(15);
        System.out.println(list.toString());
    }

    static class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> result = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                int is3 = i % 3;
                int is5 = i % 5;
                if (is3 == 0 && is5 == 0) {
                    result.add("FizzBuzz");
                } else if (is3 == 0) {
                    result.add("Fizz");
                } else if (is5 == 0) {
                    result.add("Buzz");
                } else {
                    result.add(String.valueOf(i));
                }
            }
            return result;
        }
    }
}
