package com.leetcode;

public class AddTwoNumbers {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
//        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode l2 = new ListNode(7);
        ListNode l1 = new ListNode(3, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(l1, l2);

        System.out.print("[");
        while (listNode != null) {
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
        System.out.println("]");
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return null;
            }
            int carry = 0;
            ListNode head = null, tail = null;
            while (l1 != null || l2 != null) {
                int l1Num = l1 == null ? 0 : l1.val;
                int l2Num = l2 == null ? 0 : l2.val;
                int sum = l1Num + l2Num + carry;
                carry = sum / 10;
                int num = sum % 10;
                if (head == null) {
                    head = tail = new ListNode(num);
                } else {
                    tail.next = new ListNode(num);
                    tail = tail.next;
                }

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            if (carry == 1) {
                tail.next = new ListNode(1);
            }
            return head;
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

}