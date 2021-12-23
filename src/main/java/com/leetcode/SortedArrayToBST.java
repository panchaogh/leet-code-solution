package com.leetcode;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode rootNode = new Solution().sortedArrayToBST(nums);
        System.out.println();
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }

        public TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
            if (begin > end) return null;
            int rootIndex = (begin + end) / 2;
            TreeNode leftNode = sortedArrayToBST(nums, begin, rootIndex - 1);
            TreeNode rightNode = sortedArrayToBST(nums, rootIndex + 1, end);
            return new TreeNode(nums[rootIndex], leftNode, rightNode);
        }
    }
}
