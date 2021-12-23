package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
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

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> levelList = new ArrayList<>();
                int size = queue.size();//当前层的节点数
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    levelList.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                result.add(levelList);
            }
            return result;
        }
    }
}
