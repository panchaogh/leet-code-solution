package com.leetcode;


public class HasCycle {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(listNode));
    }


    //Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }

    static class Solution {
/*        public boolean hasCycle(ListNode head) {
            ListNode current = head;
            Set<ListNode> set = new HashSet<>();
            while (current != null) {
                if (!set.add(current)) {
                    return true;
                } else {
                    current = current.next;
                }
            }
            return false;
        }*/
        public boolean hasCycle(ListNode head) {
            if(head == null || head.next == null){
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast){
                if(fast == null || fast.next == null){
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }
}
