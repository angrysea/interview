package org.interview.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LongestUnivaluePath {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int max = 0;
    int longestUnivaluePath(TreeNode root) {
        findLongest(root);
        return max;
    }

    int findLongest(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findLongest(root.left);
        int right = findLongest(root.right);

        int leftWith = 0;
        if(root.left != null && root.left.val == root.val) {
            leftWith += left + 1;
        }

        int rightWith = 0;
        if(root.right != null && root.right.val == root.val) {
            rightWith += right + 1;
        }

        max = Math.max(max, leftWith + rightWith);

        return Math.max(leftWith, rightWith);
    }

    public static void main(String[] args) {
        LongestUnivaluePath o = new LongestUnivaluePath();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(o.longestUnivaluePath(root));
    }
}
