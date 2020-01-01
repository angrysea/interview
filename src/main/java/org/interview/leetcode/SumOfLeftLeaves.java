package org.interview.leetcode;

import java.util.Stack;

public class SumOfLeftLeaves {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

    int sumLeftLeaves(TreeNode root) {
        int total = 0;
        if(root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                if(node.left.left == null && node.left.right == null) {
                    total += node.left.value;
                }
                else {
                    stack.push(node.left);
                }
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        SumOfLeftLeaves o = new SumOfLeftLeaves();
        TreeNode root = new TreeNode();
        root.value = 2;
        TreeNode nine = new TreeNode();
        nine.value = 9;
        TreeNode twenty = new TreeNode();
        twenty.value = 20;
        root.left = nine;
        root.right = twenty;
        TreeNode fifteen = new TreeNode();
        fifteen.value = 15;
        TreeNode seven = new TreeNode();
        seven.value = 7;
        twenty.left = fifteen;
        twenty.right = seven;

        System.out.printf("Sum of the left leaves is %d", o.sumLeftLeaves(root));
    }
}
