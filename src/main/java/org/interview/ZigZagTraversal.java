package org.interview;

import com.sun.source.tree.BinaryTree;

import java.util.Stack;

public class ZigZagTraversal {

    static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }


    TreeNode rootNode;

    private void printZigZagTraversal() {

        if (rootNode == null) {
            return;
        }

        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();

        currentLevel.push(rootNode);
        boolean leftToRight = true;

        while (!currentLevel.isEmpty()) {

            TreeNode node = currentLevel.pop();

            System.out.print(node.data + " ");

            if (leftToRight) {
                if (node.leftChild != null) {
                    nextLevel.push(node.leftChild);
                }

                if (node.rightChild != null) {
                    nextLevel.push(node.rightChild);
                }
            } else {
                if (node.rightChild != null) {
                    nextLevel.push(node.rightChild);
                }

                if (node.leftChild != null) {
                    nextLevel.push(node.leftChild);
                }
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }

    // driver program to test the above function
    public static void main(String[] args) {
        ZigZagTraversal tree = new ZigZagTraversal();
        tree.rootNode = new TreeNode(17);
        tree.rootNode.leftChild = new TreeNode(24);
        tree.rootNode.rightChild = new TreeNode(51);
        tree.rootNode.leftChild.leftChild = new TreeNode(99);
        tree.rootNode.rightChild.rightChild = new TreeNode(210);
        tree.rootNode.rightChild.rightChild.leftChild = new TreeNode(67);
        tree.rootNode.rightChild.rightChild.rightChild = new TreeNode(11);

        System.out.println("ZigZag Order traversal of binary tree is");
        tree.printZigZagTraversal();
    }
}
