package org.interview.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
     static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }
     }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current = current.left;
            }
            current = stack.pop();
            output.add(current.val);
            current = current.right;
        }
        return output;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal o = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        o.inorderTraversal(root).stream().forEach(i -> System.out.printf("%d, ", i));
    }
}
