package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class ReversePrint {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        head.next = listNode3;
        listNode3.next = listNode2;
        int[] result = new ReversePrint().reversePrint(head);
        System.out.println(Arrays.toString(result));
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode point = head;
        while (point != null){
            stack.push(point.val);
            point = point.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
