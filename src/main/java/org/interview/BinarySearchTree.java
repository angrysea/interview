package org.interview;

import java.util.Optional;

public class BinarySearchTree<V extends Comparable<V>> {
    static class BinarySearchTreeNode<V extends Comparable<V>> {

        private V value;
        private BinarySearchTreeNode<V> right;
        private BinarySearchTreeNode<V> left;

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
    }

    private BinarySearchTreeNode<V> root;

    private Optional<BinarySearchTreeNode<V>> insert(V value) {
        if (root == null) {
            root = new BinarySearchTreeNode<V>(value);
            return Optional.of(root);
        }
        return root.insert(value);
    }

    Optional<BinarySearchTreeNode<V>> find(V value) {
        return root.find(value);
    }

    public static void main(String[] args) {
        BinarySearchTree<Character> tree = new BinarySearchTree<>();
        tree.insert('A');
    }
}