package com.leetcode;

import java.util.Stack;

public class IsValidBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        boolean validBST = new Solution().isValidBST(treeNode);
        System.out.println(validBST);
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
        long previous = Long.MIN_VALUE;

        /**
         * 中序遍历
         */
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.val <= previous) {
                    return false;
                }
                previous = root.val;
                root = root.right;
            }
            return true;
        }

        /**
         * 递归-中序遍历
         */
        public boolean isValidBST2(TreeNode root) {
            if (root == null) return true;
            boolean leftResult = isValidBST(root.left);
            if (root.val <= previous) return false;
            previous = root.val;
            boolean rightResult = isValidBST(root.right);
            return leftResult && rightResult;
        }

        /**
         * 递归-先序遍历
         */
        public boolean isValidBST1(TreeNode root) {
            return isValidBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        /**
         * 递归
         */
        public boolean isValidBST(TreeNode root, int max, int min) {
            if (root == null) {
                return true;
            }
            if (root.val >= max || root.val >= min) {
                return false;
            }
            boolean leftValidBST = isValidBST(root.left);
            boolean rightValidBST = isValidBST(root.right);
            return leftValidBST && rightValidBST;
        }
    }
}
