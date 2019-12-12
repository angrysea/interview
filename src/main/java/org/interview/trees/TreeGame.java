package org.interview.trees;//                     0
//            1                   2
//       3         4         5         6
//    7    8    9   19    11   12   13   14

import java.util.*;
import java.util.LinkedList;

public class TreeGame {
    static class BinaryTreeNode {
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        private int data;
        private int player;

        BinaryTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.player = 0;
        }

        int getData() {
            return data;
        }

        int getPlayer() {
            return player;
        }

        void setPlayer(int player) {
            this.player = player;
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

    private List<BinaryTreeNode> getInOrder() {
        List<BinaryTreeNode> nodes = new LinkedList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        BinaryTreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            nodes.add(current);
            current = current.getRight();
        }
        return nodes;
    }

    private void resetBoard() {
        Queue<BinaryTreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            BinaryTreeNode current = nodes.remove();
            current.setPlayer(0);
            BinaryTreeNode next = current.getLeft();
            if (next != null) {
                nodes.add(next);
            }
            next = current.getRight();
            if (next != null) {
                nodes.add(next);
            }
        }
    }

    private boolean move(final int player, boolean firstTime) {

        Queue<BinaryTreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        if (!firstTime) {
            while (!nodes.isEmpty()) {
                BinaryTreeNode current = nodes.remove();
                if (current.getPlayer() == player) {
                    nodes.clear();
                    nodes.add(current);
                    break;
                }
                if (current.getLeft() != null) {
                    nodes.add(current.getLeft());
                }

                if (current.getRight() != null) {
                    nodes.add(current.getRight());
                }
            }
        }

        while (!nodes.isEmpty()) {
            BinaryTreeNode current = nodes.remove();
            if (current.getPlayer() == 0) {
                current.setPlayer(player);
                System.out.println(String.format("Player %d takes node %d", current.getPlayer(), current.getData()));
                return true;
            }

            BinaryTreeNode child = current.getLeft();
            if (child != null && (child.getPlayer() == player || child.getPlayer() == 0)) {
                nodes.add(current.getLeft());
            }

            child = current.getRight();
            if (child != null && (child.getPlayer() == player || child.getPlayer() == 0)) {
                nodes.add(current.getRight());
            }
        }
        System.out.println(String.format("Player %d has no moves left", player));
        return false;
    }

    private int findWinner(int noPlayers) {

        int[] scores = new int[noPlayers];
        for (int i = 0; i < noPlayers; ++i) {
            scores[i] = 0;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode current = stack.pop();
            if (current.getPlayer() > 0) {
                ++scores[current.getPlayer() - 1];
            }
            BinaryTreeNode next = current.getRight();
            if (next != null) {
                stack.push(next);
            }
            next = current.getLeft();
            if (next != null) {
                stack.push(next);
            }
        }

        int max = 0;
        int winner = 0;
        for (int i = 0; i < noPlayers; ++i) {
            if (scores[i] > max) {
                max = scores[i];
                winner = i + 1;
            }
        }
        return winner;
    }

    private void playTheGame(int noOfPlayers, int startingPlayer) {
        boolean firstTime = true;
        boolean[] stillPlaying = new boolean[noOfPlayers];
        for (int i = 0; i < noOfPlayers; ++i) {
            stillPlaying[i] = true;
        }

        boolean stopPlaying = false;
        while (!stopPlaying) {
            int currentPlayer = startingPlayer;
            for (int i = 0; i < noOfPlayers; ++i) {
                if (stillPlaying[currentPlayer - 1]) {
                    stillPlaying[currentPlayer - 1] = move(currentPlayer, firstTime);
                }
                ++currentPlayer;
                if (currentPlayer > noOfPlayers) {
                    currentPlayer = 1;
                }
            }
            firstTime = false;
            stopPlaying = true;
            for (int i = 0; i < noOfPlayers; ++i) {
                if (stillPlaying[i]) {
                    stopPlaying = false;
                    break;
                }
            }
        }
    }

    private void printGameResults() {
        System.out.print("Print Level Order Traversal: ");
        Queue<BinaryTreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            BinaryTreeNode current = nodes.remove();
            System.out.print(String.format("(%d, %d) - ", current.getData(), current.getPlayer()));
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

    void convert() {
        List<BinaryTreeNode> nodes = getInOrder();
        nodes.sort(new Comparator<BinaryTreeNode>() {
            @Override
            public int compare(BinaryTreeNode o1, BinaryTreeNode o2) {
                return o1.getData() ;
            }
        });

    }

    public static void main(String[] args) {
        int[] values = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        TreeGame tree = new TreeGame();
        tree.loadTree(values);

        tree.playTheGame(3, 1);
        int winner = tree.findWinner(3);
        if (winner == 0) {
            System.out.println("It's a tie.!!!!");
        } else {
            System.out.println(String.format("Player %d Wins!!!!", winner));
        }
        tree.printLevelOrderTraversal();

        tree.resetBoard();
        tree.playTheGame(2, 2);
        winner = tree.findWinner(2);
        if (winner == 0) {
            System.out.println("It's a tie.!!!!");
        } else {
            System.out.println(String.format("Player %d Wins!!!!", winner));
        }
        tree.printGameResults();
    }
}
