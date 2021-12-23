package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {
    public static void main(String[] args) {

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        /**
         * 递归或排序
         */
        public boolean isSymmetric(TreeNode root) {
            return isSymmetric(root, root);
        }

        /**
         * 递归
         */
        public boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }

        /**
         * 遍历
         */
        public boolean isSymmetric1(TreeNode left, TreeNode right) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(left);
            queue.offer(right);
            while (!queue.isEmpty()) {
                TreeNode pollLeft = queue.poll();
                TreeNode pollRight = queue.poll();
                if (pollLeft == null && pollRight == null) {
                    continue;
                }
                if (pollLeft == null || pollRight == null) {
                    return false;
                }
                if (pollLeft.val != pollRight.val) {
                    return false;
                }
                queue.offer(pollLeft.left);
                queue.offer(pollRight.right);
                queue.offer(pollLeft.right);
                queue.offer(pollRight.left);
            }
            return true;
        }
    }
}
