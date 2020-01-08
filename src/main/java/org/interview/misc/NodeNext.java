package org.interview.misc;

import java.util.Arrays;

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
        else if (this.value < value) {
            if(right != null) {
                return right.insert(value);
            }
            else {
                right = new NodeNext(value);
                right.parent = this;
                return right;
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

        int[] values = {35,45,30,32,50,52,25,27,55,57,20,22,60,62,15,17,65,67,10,12,70,5,75,76};
        Arrays.stream(values).forEach(v -> root.insert(v));
        NodeNext node = root.insert(1);

        while((node = node.next()) != null) {
            System.out.println(node.value);
        }
    }
}
