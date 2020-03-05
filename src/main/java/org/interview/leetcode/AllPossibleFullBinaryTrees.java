package org.interview.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPossibleFullBinaryTrees {
     static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }
     }

     public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> output = new ArrayList<>();
        if (N % 2 == 0) {
            return output;
        }

        if (N == 1) {
            output.add(new TreeNode(0));
            return output;
        }

        for(int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i - 1);
            for(TreeNode leftNode : left) {
                for(TreeNode rightNode : right) {
                    TreeNode current = new TreeNode(0);
                    current.left = leftNode;
                    current.right = rightNode;
                    output.add(current);
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        AllPossibleFullBinaryTrees o = new AllPossibleFullBinaryTrees();
        o.allPossibleFBT(7)
                .stream()
                .forEach(treeNode -> System.out.println(treeNode.val));
    }
}
