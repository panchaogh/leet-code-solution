package com.leetcode;

import java.util.Stack;

/**
 * 最小栈
 */
public class MinStack {
    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }

    static class Solution {
        private final Stack<Integer> stack;
        private final Stack<Integer> minValueStack;

        public Solution() {
            stack = new Stack<>();
            minValueStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minValueStack.isEmpty()) {
                minValueStack.push(val);
            } else {
                minValueStack.push(Math.min(minValueStack.peek(), val));
            }
        }

        public void pop() {
            stack.pop();
            minValueStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minValueStack.peek();
        }
    }
}
