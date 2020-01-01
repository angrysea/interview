package org.interview.trees;

import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;

public class BinarySearchTree<V extends Comparable<V>> {
    public static class BinarySearchTreeNode<V extends Comparable<V>> {

        public V value;
        public BinarySearchTreeNode<V> right;
        public BinarySearchTreeNode<V> left;

        BinarySearchTreeNode(V value) {
            this.value = value;
            right = null;
            left = null;
        }

        Optional<BinarySearchTreeNode<V>> insert(V value) {
            if (this.value.compareTo(value) > 0) {
                if(left != null) {
                    left.insert(value);
                }
                else {
                    left = new BinarySearchTreeNode<>(value);
                    return Optional.of(left);
                }
            }
            else if (this.value.compareTo(value) < 0) {
                if(right != null) {
                    right.insert(value);
                }
                else {
                    right = new BinarySearchTreeNode<>(value);
                    return Optional.of(right);
                }
            }
            return Optional.empty();
        }

        Optional<BinarySearchTreeNode<V>> find(V value) {
            if(this.value.equals(value)) {
                return Optional.of(this);
            }

            if (this.value.compareTo(value) > 0) {
                if (left != null) {
                    return left.find(value);
                }
            }
            else if (right != null) {
                return right.find(value);
            }
            return Optional.empty();
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public BinarySearchTreeNode<V> getRight() {
            return right;
        }

        public void setRight(BinarySearchTreeNode<V> right) {
            this.right = right;
        }

        public BinarySearchTreeNode<V> getLeft() {
            return left;
        }

        public void setLeft(BinarySearchTreeNode<V> left) {
            this.left = left;
        }
    }

    public BinarySearchTreeNode<V> root;

    public Optional<BinarySearchTreeNode<V>> insert(V value) {
        if (root == null) {
            root = new BinarySearchTreeNode<V>(value);
            return Optional.of(root);
        }
        return root.insert(value);
    }

    Optional<BinarySearchTreeNode<V>> find(V value) {
        return root.find(value);
    }

    private void printInOrderTraversal() {
        System.out.print("Print In Order Traversal nr: ");
        Stack<BinarySearchTreeNode<V>> stack = new Stack<>();
        BinarySearchTreeNode<V> current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            System.out.printf("%d, ", current.getValue());

            current = current.getRight();
        }
        System.out.println();
    }

    private Optional<V> finKthSmallest(int k) {
        int count = 0;
        Stack<BinarySearchTreeNode<V>> stack = new Stack<>();
        BinarySearchTreeNode<V> current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            if(++count == k) {
                return Optional.of(current.getValue());
            }

            current = current.getRight();
        }
        System.out.println();
        return null;
    }

    public static void main(String[] args) {
        int[] values = new int[]{5, 13, 14, 6, 7, 8, 1, 2, 3, 9, 10, 0, 4, 11, 12};

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Arrays.stream(values).forEach(tree::insert);
        tree.printInOrderTraversal();
        var node = tree.find(7);
        node.ifPresentOrElse((v) -> System.out.println(v.getValue()),
                () -> {System.out.println("Not found");});

        int k = 5;
        tree.finKthSmallest(k).ifPresentOrElse(v ->
                System.out.printf("Find %dth smallest value is " + v, k),
                () -> {System.out.print("Doesnt exist");});
    }
}