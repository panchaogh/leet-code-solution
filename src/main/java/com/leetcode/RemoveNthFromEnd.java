package com.leetcode;

import java.util.Stack;

/**
 * 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution solution = new Solution();
        ListNode result = solution.removeNthFromEnd(listNode, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        /**
         * 双指针解法
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            ListNode slow = dummy, fast = head;
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }

        /**
         * 栈解法
         */
        public ListNode removeNthFromEnd2(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            ListNode current = dummy;
            Stack<ListNode> stack = new Stack<>();
            while (current != null) {
                stack.push(current);
                current = current.next;
            }
            for (int i = 0; i < n; i++) {
                stack.pop();
            }
            ListNode peek = stack.peek();
            peek.next = peek.next.next;
            return dummy.next;
        }

        /**
         * 计算链表长度
         */
        public ListNode removeNthFromEnd1(ListNode head, int n) {
            int listLength = length(head);
            ListNode dummy = new ListNode(0, head);
            ListNode current = dummy;
            for (int i = 1; i < listLength - n + 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            return dummy.next;
        }

        public int length(ListNode head) {
            int length = 0;
            ListNode tmp = head;
            while (tmp != null) {
                length++;
                tmp = tmp.next;
            }
            return length;
        }
    }
}
