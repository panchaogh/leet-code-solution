package com.leetcode;

/**
 * 合并两个有序链表
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(3,new ListNode(5,new ListNode(7,new ListNode(9)))));
        ListNode l2 = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(8, new ListNode(10)))));
        Solution solution = new Solution();
        ListNode listNode = solution.mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
        System.out.println();
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    current.next = l1;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    l2 = l2.next;
                }
                current = current.next;
            }
            if (l1 != null) {
                current.next = l1;
            }
            if (l2 != null) {
                current.next = l2;
            }
            return dummy.next;
        }
    }
}
