package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 */
public class RomanToInt {
    public static void main(String[] args) {
        int result = new Solution().romanToInt("IM");
        System.out.println(result);
    }

    static class Solution {
        public int romanToInt(String s) {
            Map<Character, Integer> map = new HashMap<Character, Integer>() {{
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }};
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                Integer count = map.get(c);
                if (i + 1 < s.length() && count < map.get(s.charAt(i + 1))) {
                    count = -count;
                }
                result += count;
            }
            return result;
        }
    }
}
