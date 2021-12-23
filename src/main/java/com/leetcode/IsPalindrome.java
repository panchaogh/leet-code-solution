package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2,new ListNode(1)))));
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(listNode));
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
        public boolean isPalindrome1(ListNode head) {
            List<ListNode> list = new ArrayList<>();
            while (head != null) {
                list.add(head);
                head = head.next;
            }
            int size = list.size();
            for (int i = 0; i < size / 2; i++) {
                if (list.get(i).val != list.get(size - i - 1).val) {
                    return false;
                }
            }
            return true;
        }

        public boolean isPalindrome(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode tail = slow.next;
            ListNode pre = null, current = tail, next = null;
            while (current != null) {
                next = current.next;
                current.next = pre;
                pre = current;
                current = next;
            }

            while (pre != null){
                if(head.val != pre.val){
                    return false;
                }
                head = head.next;
                pre = pre.next;
            }
            return true;
        }
    }
}
