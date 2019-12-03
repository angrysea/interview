package org.interview;//                     0
//            1                   2
//       3         4         5         6
//    7    8    9   19    11   12   13   14
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree {
    static class BinaryTreeNode {
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        private int data;

        BinaryTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        int getData() {
            return data;
        }

        void insertRight(BinaryTreeNode right) {
            this.right = right ;
        }

        void insertLeft(BinaryTreeNode left) {
            this.left = left;
        }

        BinaryTreeNode getLeft() {
            return left;
        }

        BinaryTreeNode getRight() {
            return right;
        }
    }

    private BinaryTreeNode root;

    public BinaryTreeNode setRoot(int value) {
        root = new BinaryTreeNode(value);
        return root;
    }

    private BinaryTreeNode loadTree(int[] values) {
        Queue<BinaryTreeNode> nodes = new LinkedList<>();
        for (int i : values) {
            nodes.add(new BinaryTreeNode(i));
        }

        root = nodes.remove();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        BinaryTreeNode parent;
        BinaryTreeNode current;
        while (!nodes.isEmpty()) {
            parent = queue.remove();
            current = nodes.remove();
            parent.insertLeft(current);
            queue.add(current);
            if (!nodes.isEmpty()) {
                current = nodes.remove();
                parent.insertRight(current);
                queue.add(current);
            }
        }
        return root;
    }

    private void printPostOrderTraversal() {
        System.out.print("Print Post Order Traversal: ");
        Stack<BinaryTreeNode> nodes = new Stack<>();
        Queue<BinaryTreeNode> currentLevel = new LinkedList<>();
        Queue<BinaryTreeNode> nextLevel = new LinkedList<>();
        currentLevel.add(root);
        while (!currentLevel.isEmpty()) {
            while (!currentLevel.isEmpty()) {
                BinaryTreeNode current = currentLevel.remove();
                nodes.push(current);
                if (current.getRight() != null) {
                    nextLevel.add(current.getRight());
                }
                if (current.getLeft() != null) {
                    nextLevel.add(current.getLeft());
                }
            }
            Queue<BinaryTreeNode> temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;
        }

        while (!nodes.isEmpty()) {
            BinaryTreeNode current = nodes.pop();
            System.out.print(current.getData());
            System.out.print(", ");
        }
        System.out.println();
    }

    private void printLevelOrderTraversal() {
        System.out.print("Print Level Order Traversal: ");
        Queue<BinaryTreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            BinaryTreeNode current = nodes.remove();
            System.out.print(String.format("%d, ", current.getData()));
            BinaryTreeNode next = current.getLeft();
            if (next != null) {
                nodes.add(next);
            }
            next = current.getRight();
            if (next != null) {
                nodes.add(next);
            }
        }
        System.out.println();
    }

    private void printPreOrderTraversal() {
        System.out.print("Print Pre Order Traversal: ");
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode current = stack.pop();
            System.out.print(String.format("%d, ", current.getData()));
            BinaryTreeNode next = current.getRight();
            if (next != null) {
                stack.push(next);
            }
            next = current.getLeft();
            if (next != null) {
                stack.push(next);
            }
        }
        System.out.println();
    }

    private void printInOrderTraversal() {
        printInOrderTraversalRec();
        System.out.print("Print In Order Traversal nr: ");
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        BinaryTreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            System.out.print(String.format("%d, ", current.getData()));

            current = current.getRight();
        }
        System.out.println();
    }

    private void printInOrderTraversalRec() {
        System.out.print("Print In Order Traversal: ");
        printNode(root);
        System.out.println();
    }

    private void printNode(BinaryTreeNode current) {
        if (current != null) {
            printNode(current.getLeft());
            System.out.print(current.getData());
            System.out.print(", ");
            printNode(current.getRight());
        }
    }

    public static void main(String[] args) {
        int[] values = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        BinaryTree tree = new BinaryTree();
        tree.loadTree(values);
        tree.printLevelOrderTraversal();
        tree.printPostOrderTraversal();
        tree.printInOrderTraversal();
        tree.printPreOrderTraversal();
    }
}
