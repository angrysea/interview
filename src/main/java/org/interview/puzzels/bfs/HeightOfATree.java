package org.interview.puzzels.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfATree {
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    int treeHeight(final Node root) {
        int height = 0;
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> nextLevel = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            height++;
            while(!queue.isEmpty()) {
                Node node = queue.poll();
                if(node != null) {
                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }
                }
            }
            Queue<Node> tempQueue = queue;
            queue = nextLevel;
            nextLevel = tempQueue;
        }
        return height;
    }

    int treeHeight2(final Node root) {
        int height = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(true) {
            int levelNodeCount = queue.size();
            if (levelNodeCount == 0) {
                return height;
            }
            height++;

            while(levelNodeCount > 0) {
                Node node = queue.poll();
                if(node != null) {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    levelNodeCount--;
                }
            }
        }
    }

    static int getLength(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftLen = getLength(node.left);
            int rightLen = getLength(node.right);
            return Math.max(leftLen, rightLen) + 1;
        }
    }

    public static void main(String[] args) {

        Node three = new Node(3);
        Node two = new Node(2);
        three.left = two;
        two.left = new Node(1);
        Node five = new Node(4);
        three.right = five;
        three.left = new Node(5);
        Node six = new Node(6);
        five.right = six;
        six.right = new Node(7);

        System.out.println(new HeightOfATree().treeHeight(three));
        System.out.println(new HeightOfATree().treeHeight2(three));
        System.out.println(getLength(three));
    }
}
