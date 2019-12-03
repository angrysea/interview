package org.interview;// Write a function to print ZigZag order traversal of a binary tree.
//                  7
//                /  \
//               4    5
//              /      \
//             9       10
//            / \
//           6   11
//
// 7 5 4 9 10 11 6

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class PrintTraversal {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private void printLevelTraversal(TreeNode rootNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    private void printZigZagTraversal(TreeNode rootNode) {

        // if null then return
        if (rootNode == null) {
            return;
        }

        // declare two stacks
        Stack<TreeNode> currentLevel = new Stack<>();

        // push the root
        currentLevel.push(rootNode);
        boolean leftToRight = true;

        // check if stack is empty
        while (!currentLevel.isEmpty()) {
            Stack<TreeNode> nextLevel = new Stack<>();

            // pop out of stack
            TreeNode node = currentLevel.pop();

            // print the data in it
            System.out.print(node.data + " ");

            // store data according to current
            // order.
            if (leftToRight) {
                if (node.left != null) {
                    nextLevel.push(node.left);
                }

                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            } else {
                if (node.right != null) {
                    nextLevel.push(node.right);
                }

                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                currentLevel = nextLevel;
            }
        }
    }

    void printInOrderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    private void printInOrderTraversal(TreeNode rootNode) {

        // if null then return
        if (rootNode == null) {
            return;
        }
        int [] x = new int[]{58, 13, 42, 20, 31, 24, 76, 19, 88};
        // declare two stacks
        Stack<TreeNode> currentLevel = new Stack<>();
        TreeNode current = rootNode;
        // push the root
        // check if stack is empty
        while (!currentLevel.isEmpty() || current != null) {

            if (current != null) {
                currentLevel.push(current);
                current = current.left;
            } else {
                TreeNode node = currentLevel.pop();
                System.out.print(node.data + " ");
                current = node.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(9);
        root.right.right = new TreeNode(10);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(11);

        PrintTraversal pt = new PrintTraversal();
        pt.printZigZagTraversal(root);
        System.out.println();
        pt.printInOrderTraversal(root);
        System.out.println();
        pt.printInOrderTraversal2(root);
        System.out.println();
        pt.printLevelTraversal(root);
    }
}

