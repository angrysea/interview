package org.interview.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumDistanceBetweenBSTNodes {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    static public int minDiffInBST(TreeNode root) {
        return minDiffInBSTUtil(root, null, Integer.MAX_VALUE);
    }

    static int minDiffInBSTUtil(TreeNode node, Integer prev, int currentMin) {
        if (node == null) {
            return currentMin;
        }
        return minDiffInBSTUtil(node, prev, currentMin);
    }

    static public int minDiffInBST2(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        minDiffInBSTUtil2(root, nodes);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < nodes.size(); i++) {
            min = Math.min(min, nodes.get(i) - nodes.get(i-1));
        }
        return min;
    }

    static void minDiffInBSTUtil2(TreeNode node, List<Integer> nodes) {
        if (node == null) {
            return;
        }
        minDiffInBSTUtil2(node.left, nodes);
        nodes.add(node.val);
        minDiffInBSTUtil2(node.right, nodes);
    }

/*
  4,2,6,1,3
                90
           69
        49     89
          52
 */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(90);
        root.left = new TreeNode(69);
        root.left.left = new TreeNode(49);
        root.left.right = new TreeNode(89);
        root.left.left.right = new TreeNode(52);
        System.out.println(minDiffInBST(root));
    }
}
