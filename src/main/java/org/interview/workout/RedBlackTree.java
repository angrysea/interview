package org.interview.workout;

import org.interview.trees.BinaryTree;

import java.util.*;
import java.util.stream.IntStream;

public class RedBlackTree {
    enum NodeColor {RED, BLACK}

    static class Node {
        int val;
        Node right;
        Node left;
        Node parent;
        NodeColor color;

        Node(int val) {
            this.val = val;
        }

        void setAsRoot() {
            color = NodeColor.BLACK;
            parent = null;
        }
    }

    Node root;

    Node insert(int val) {
        Node node = null;
        if (root == null) {
            root = new Node(val);
            root.setAsRoot();
            return root;
        }

        Node current = root;
        while (true) {
            if (val == current.val) {
                return current;
            }

            if (val < current.val) {
                if (current.left == null) {
                    current.left = new Node(val);
                    current.left.parent = current;
                    node = current.left;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(val);
                    current.right.parent = current;
                    node = current.right;
                    break;
                }
                current = current.right;
            }
        }

        postInsert(node);

        return node;
    }

    void postInsert(Node node) {

        node.color = NodeColor.RED;

        while (node != root && node.parent.color == NodeColor.RED) {
            if (node.parent == node.parent.parent.left) {
                Node uncle = node.parent.parent.right;
                if (uncle != null && uncle.color == NodeColor.RED) {
                    node.parent.color = NodeColor.BLACK;
                    uncle.color = NodeColor.BLACK;
                    node.parent.parent.color = NodeColor.RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        leftRotate(node);
                    }
                    node.parent.color = NodeColor.BLACK;
                    node.parent.parent.color = NodeColor.RED;
                    rightRotate(node.parent.parent);
                }
            } else {
                Node uncle = node.parent .parent.left;
                if (uncle != null && uncle.color == NodeColor.RED) {
                    node.parent.color = NodeColor.BLACK;
                    uncle.color = NodeColor.BLACK;
                    node.parent .parent.color = NodeColor.RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rightRotate(node);
                    }
                    node.parent.color = NodeColor.BLACK;
                    node.parent.parent.color = NodeColor.RED;
                    leftRotate(node.parent.parent);
                }
            }
        }
        root.color = NodeColor.BLACK;
    }


    void leftRotate(Node node) {
        Node right = node.right;
        node.right = right.left;

        if (right.left != null) {
            right.left.parent = node;
        }
        right.parent = node.parent;

        if (node.parent == null) {
            root = right;
        }
        else if (node == node.parent.left) {
            node.parent.left = right;
        }
        else {
            node.parent.right = right;
        }
        right.left = node;
        node.parent = right;
    }

    void rightRotate(Node node) {
        Node left = node.left;
        node.left = left.right;

        if (left.right != null) {
            left.right.parent = node;
        }
        left.parent = node.parent;

        if (node.parent == null) {
            root = left;
        }
        else if (node == node.parent.right) {
            node.parent.right = left;
        }
        else {
            node.parent.left = left;
        }
        left.right = node;
        node.parent = left;
    }

    private void printTree() {
        List<List<Node>> levelOrder = new ArrayList<>();
        Queue<Node> currentLevel = new LinkedList<>();
        currentLevel.add(root);
        Queue<Node> nextLevel = new LinkedList<>();
        while (!currentLevel.isEmpty()) {
            List<Node> level = new ArrayList<>();
            while (!currentLevel.isEmpty()) {
                Node current = currentLevel.remove();
                level.add(current);
                Node next = current.left;
                if (next != null) {
                    nextLevel.add(next);
                }
                next = current.right;
                if (next != null) {
                    nextLevel.add(next);
                }
            }

            if(!level.isEmpty()) {
                levelOrder.add(level);
            }

            Queue<Node> temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;
        }
        System.out.print("Print Level Order Traversal: ");
        System.out.println();
        levelOrder.forEach(list -> {
            list.forEach(node -> System.out.printf("%d-%d  ", node.val,
                node.parent != null ? node.parent.val : 0));
            System.out.println();
        });
        System.out.println();
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        IntStream.iterate(0, i -> i + 5).limit(2000).forEach(tree::insert);
        tree.printTree();
    }
}
