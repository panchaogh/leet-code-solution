package com.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxDepth {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int maxDepth = new Solution().maxDepth(treeNode);
        System.out.println(maxDepth);
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
         * 深度优先搜索
         */
        public int maxDepth1(TreeNode root) {
            if (root == null) return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return (Math.max(left, right)) + 1;
        }

        /**
         * 广度优先搜索
         */
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int maxDepth = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode tmp = queue.poll();
                    if (tmp.left != null) queue.offer(tmp.left);
                    if (tmp.right != null) queue.offer(tmp.right);
                    size--;
                }
                maxDepth++;
            }
            return maxDepth;
        }
    }
}
