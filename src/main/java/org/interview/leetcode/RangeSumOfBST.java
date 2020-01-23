package org.interview.leetcode;

import org.interview.trees.BinarySearchTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RangeSumOfBST {

    int rangeSum(BinarySearchTree.BinarySearchTreeNode<Integer> root, int l, int r) {
        int total = 0;
        if(root == null || l > r) {
            return 0;
        }

        Queue<BinarySearchTree.BinarySearchTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinarySearchTree.BinarySearchTreeNode<Integer> current = queue.remove();

            if(current.value >= l && current.value <= r) {
                total += current.value;
            }
            if(current.left != null && current.value > l) {
                queue.add(current.left);
            }
            if(current.right != null && current.value < r) {
                queue.add(current.right);
            }
        }
        return total;
    }

    static public void main(String[] args) {
        int[] values = new int[]{10,5,15,3,7,18};
        int l = 7;
        int r = 15;

//        values = new Integer[]{10,5,15,3,7,13,18,1,6};
//        int l = 6;
//        int r = 10;

        BinarySearchTree<Integer> tree = new BinarySearchTree();
        Arrays.stream(values).forEach(i -> tree.insert(i));

        BinarySearchTree.BinarySearchTreeNode<Integer> root = tree.root;
        RangeSumOfBST o = new RangeSumOfBST();
        System.out.printf("Sum of the node in range %d to %d, is %d.\n", l, r,
                o.rangeSum(root, l, r));


    }
}
