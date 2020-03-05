package org.interview.trees;
//                     0
//            1                   2
//       3         4         5         6
//    7    8    9   10    11   12   13   14
import java.util.*;

public class BinaryTree {
    public static class BinaryTreeNode {
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        private int data;

        BinaryTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public int getData() {
            return data;
        }

        void insertRight(BinaryTreeNode right) {
            this.right = right;
        }

        void insertLeft(BinaryTreeNode left) {
            this.left = left;
        }

        public BinaryTreeNode getLeft() {
            return left;
        }

        public BinaryTreeNode getRight() {
            return right;
        }
    }

    private BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public BinaryTreeNode setRoot(int value) {
        root = new BinaryTreeNode(value);
        return root;
    }

    public BinaryTreeNode loadTree(Integer[] values) {
        Queue<BinaryTreeNode> nodes = new LinkedList<>();
        for (Integer i : values) {
            if(i != null) {
                nodes.add(new BinaryTreeNode(i));
            }
            else {
                nodes.add(null);
            }
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

    BinaryTreeNode treeMin() {
        return treeMin(root);
    }

    BinaryTreeNode treeMin(BinaryTreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    BinaryTreeNode treeMax() {
        return treeMax(root);
    }

    BinaryTreeNode treeMax(BinaryTreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
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

    private void
    printLevelOrderTraversal() {
        List<List<BinaryTreeNode>> levelOrder = new ArrayList<>();
        Queue<BinaryTreeNode> currentLevel = new LinkedList<>();
        currentLevel.add(root);
        Queue<BinaryTreeNode> nextLevel = new LinkedList<>();
        while (!currentLevel.isEmpty()) {
            List<BinaryTreeNode> level = new ArrayList<>();
            while (!currentLevel.isEmpty()) {
                BinaryTreeNode current = currentLevel.remove();
                level.add(current);
                BinaryTreeNode next = current.getLeft();
                if (next != null) {
                    nextLevel.add(next);
                }
                next = current.getRight();
                if (next != null) {
                    nextLevel.add(next);
                }
            }

            if(!level.isEmpty()) {
                levelOrder.add(level);
            }

            Queue<BinaryTreeNode> temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;
        }
        System.out.print("Print Level Order Traversal: ");
        levelOrder.forEach(list -> list.forEach(node ->
                System.out.printf("%d, ", node.getData())));
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
        BinaryTreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            System.out.printf("%d, ", current.getData());

            current = current.getRight();
        }
        System.out.println();
    }

    private void printInOrderTraversalRec() {
        System.out.print("Print In Order Traversal: ");
        printNode(root);
        System.out.println();
    }

    private boolean IsSymmetric() {
        List<BinaryTreeNode> nodes = new ArrayList<>();
        Queue<BinaryTreeNode> currentLevel = new LinkedList<>();
        Queue<BinaryTreeNode> nextLevel = new LinkedList<>();
        if (root.getRight() != null) {
            currentLevel.add(root.getRight());
        }
        if (root.getLeft() != null) {
            currentLevel.add(root.getLeft());
        }

        while (!currentLevel.isEmpty()) {
            while (!currentLevel.isEmpty()) {
                BinaryTreeNode current = currentLevel.remove();
                nodes.add(current);
                if(current != null) {
                    nextLevel.add(current.getRight());
                    nextLevel.add(current.getLeft());
                }
            }
            int size = nodes.size();
            if((size % 2) > 0) {
                System.out.println("Is not symmetric!");
                return false;
            }

            for(int i = 0, j = size - 1; i < j; i++, j--) {
                BinaryTreeNode right = nodes.get(i);
                BinaryTreeNode left = nodes.get(j);
                if (right == null && left == null) {
                    continue;
                }

                if(right == null || left == null || right.getData() != left.getData()) {
                    System.out.println("Is not symmetric!");
                    return false;
                }
            }
            nodes.clear();
            Queue<BinaryTreeNode> temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;
        }

        System.out.println("Is Symmetric!!!!!");
        return true;
    }

    private void printNode(BinaryTreeNode current) {
        if (current != null) {
            printNode(current.getLeft());
            System.out.printf("%d, ", current.getData());
            printNode(current.getRight());
        }
    }

     public static void main(String[] args) {
        Integer[] values = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
//        int[] values = new int[]{0, 1, 1, 2, 3, 3, 2, 4, 5, 6, 7, 7, 6, 5, 4};
        BinaryTree tree = new BinaryTree();
        tree.loadTree(values);
        tree.IsSymmetric();
        tree.printLevelOrderTraversal();
        tree.printPostOrderTraversal();
        tree.printInOrderTraversal();
        tree.printPreOrderTraversal();
//        values = new Integer[]{0, 1, 1, 2, 3, 3, 2, 4, 5, 6, 7, 7, 6, 5, 4};
//        tree = new BinaryTree();
//        tree.loadTree(values);
//        tree.IsSymmetric();
//
//        values = new Integer[]{0, 1, 1, 2, 3, 3, 2, null, 5, 6, 7, 7, null, 6, 5};
//        Queue<BinaryTreeNode> test = new LinkedList<>();
//        Arrays.stream(values).forEach(value -> {
//            if(value == null) {
//                test.add(null);
//            }
//            else {
//                test.add(new BinaryTreeNode(value));
//
//            }
//        });
//        while(!test.isEmpty()) {
//            BinaryTreeNode node = test.remove();
//            if(node == null) {
//                System.out.println("Node is null");
//            }
//        }
//        tree = new BinaryTree();
//        tree.loadTree(values);
//        tree.IsSymmetric();
    }
}
