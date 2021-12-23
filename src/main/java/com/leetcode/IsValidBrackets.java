package com.leetcode;

import java.util.Stack;

/**
 * 有效的括号
 */
public class IsValidBrackets {
    public static void main(String[] args) {
        boolean valid = new Solution().isValid("([])");
        System.out.println(valid);
    }

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                    continue;
                }
                if (!stack.isEmpty() && ((c == ')' && stack.peek() == '(') || (c == '}' && stack.peek() == '{') || (c == ']' && stack.peek() == '['))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
