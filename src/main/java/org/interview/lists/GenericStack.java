package org.interview.lists;

import java.util.Arrays;

public class GenericStack<T> {
    private static class GenericNode<T> {
        private T data;
        private GenericNode<T> next;

        private GenericNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private GenericNode<T> top;

    private boolean isEmpty() {
        return top == null;
    }

    private T peek() {
        if(top == null) {
            throw new NullPointerException("Head stack is emptu.");
        }
        return top.data;
    }

    private void push(final T value) {
        GenericNode<T> node = new GenericNode<>(value);
        node.next = top;
        top = node;
    }

    private T pop() {
        if(top == null) {
            throw new NullPointerException("Head stack is emptu.");
        }
        T value = top.data;
        top = top.next;
        return value;
    }

    public static void main(String[] args) {
        final Integer [] ms = { 2, 4, 5, 7, 1, 2, 3, 6 };
        final GenericStack<Integer> queue = new GenericStack<>();

        try {
            System.out.println(queue.peek());
        }
        catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }

        Arrays.stream(ms).forEach(queue::push);

        while(!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
    }
}
