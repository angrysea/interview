package org.interview.lists;

import java.util.Arrays;

public class GenericQueue<T> {
    static class GenericNode<T> {
        private T data;
        private GenericNode<T> next;

        private GenericNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private GenericNode<T> head;
    private GenericNode<T> tail;

    GenericQueue() {
        this.head = null;
        this.tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    T peek() {
        if(head == null) {
            throw new NullPointerException("Head queue is emptu.");
        }
        return head.data;
    }

    void add(T value) {
        if(tail == null) {
            tail = new GenericNode<>(value);
            head = tail;
        }
        else {
            tail.next = new GenericNode<>(value);
            tail = tail.next;
        }
    }

    public T remove() {
        if(head == null) {
            throw new NullPointerException("Head queue is emptu.");
        }
        T value = head.data;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        return value;
    }

    public static void main(String[] args) {
        Integer [] ms = { 2, 4, 5, 7, 1, 2, 3, 6 };
        GenericQueue<Integer> queue = new GenericQueue<>();
        try {
            queue.remove();
        }
        catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }
        Arrays.stream(ms).forEach(queue::add);
        while(!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
