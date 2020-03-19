package org.interview.trees;

import java.util.Arrays;
/*
35,45,30,32,50,52,25,27,55,57,20,22,15,17,10,12,70,5,14,11,
  19,23,26,47,46,49,48,56,59

                             35
                            /   \
                         30      45
                        /          \
                      32             50
                      /             /  \
                   25             47    52
                 /     \         /   \    \
               20       27      46   49    55
             /  \      /         \           \
           15    22   26          48         57
           / \    \
        10    17   23
       /  \    \
      5    12   19
     /  \    \
    1    11  14



 */
public class NodeNext {
    int value;
    NodeNext parent;
    NodeNext left;
    NodeNext right;

    NodeNext(int value) {
        this.value = value;
    }

    NodeNext insert(int value) {
        if (this.value > value) {
            if(left != null) {
                return left.insert(value);
            }
            else {
                left =  new NodeNext(value);
                left.parent = this;
                return left;
            }
        }
        else {
            if(right != null) {
                return right.insert(value);
            }
            else {
                right = new NodeNext(value);
                right.parent = this;
                return right;
            }
        }
    }

    NodeNext find(int value) {
        if (this.value == value) {
            return this;
        }
        if (this.value > value) {
            if (left != null) {
                return left.find(value);
            }
        }
        else {
            if(right != null) {
                return right.find(value);
            }
        }
        return null;
    }

    NodeNext next() {
        NodeNext next = right;
        if(right != null) {
            while(next.left != null) {
                next = next.left;
            }
        }
        else {
            if (parent == null) {
                return null;
            }
            if(this.parent.left == this) {
                next = this.parent;
            }
            else {
                NodeNext temp = this;
                while (temp.parent != null && temp.parent.right == temp) {
                    temp = temp.parent;
                }
                if (temp != this && temp.parent != null && temp.parent.right == temp) {
                    next = temp;
                } else {
                    next = temp.parent;
                }
            }
        }
        return next;
    }


    static public void main(String[] args) {
        NodeNext root = new NodeNext(40);

        int[] values = {1,35,45,30,32,50,52,25,27,55,57,20,22,60,62,15,17,65,67,10,12,70,
                5,75,76,14,11,19,23,26,47,46,49,48,56,59,61};
        Arrays.stream(values).forEach(v -> root.insert(v));
        NodeNext node = root.find(23);

        while((node = node.next()) != null) {
            System.out.println(node.value);
        }
    }
}
