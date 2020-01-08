package org.interview.lists;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.Iterator;
import java.util.Scanner;

public class LinkedList<T> {
    static class Node<T> {

        private T data;

        Node<T> next;

        Node(T value) {
            data = value;
            next = null;
        }

        Node(Node<T> previous, T value) {
            data = value;
            previous.next = this;
        }
    }

    static class ListIterator<T> implements Iterator<T> {
        Node<T> next;

        ListIterator(Node<T> start) {
            this.next = start;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            final T data = next.data;
            next = next.next;
            return data;
        }
    }

    Node<T> root;
    private Node<T> tail;

    public LinkedList() {
        this.root = null;
        this.tail = null;
    }

    public ListIterator<T> listIterator() {
        return new ListIterator<>(root);
    }


    boolean isEmpty() {
        return root == null;
    }

    T peek() {
        if(root == null) {
            throw new NullPointerException("root queue is empty.");
        }
        return root.data;
    }

    public void add(T value) {
        if(tail == null) {
            tail = new Node<>(value);
            root = tail;
        }
        else {
            tail.next = new Node<>(value);
            tail = tail.next;
        }
    }

    public T remove() {
        if(root == null) {
            throw new NullPointerException("root queue is empty.");
        }
        T value = root.data;
        root = root.next;
        if(root == null) {
            tail = null;
        }
        return value;
    }

    // prints content of double linked list
    void printList() {
        Node<T> node = root;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        final String filename = "D:\\workspace\\interview\\data\\kingjames.txt";
//        final String filename = "/Users/graffeoa/workspace/data/kingjames.txt";
        Instant start = Instant.now();
        try (Scanner scanner = new Scanner(new File(filename))) {
            int value = 0;
            while (scanner.hasNext()) {
                String line = scanner.next();
                list.add(line);
                value++;
            }
            System.out.println("Number of words stored: " + value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Milli seconds to load: " + timeElapsed);

        ListIterator<String> it = list.listIterator();
        int value = 0;
        start = Instant.now();
        while(it.hasNext()) {
            var word = it.next();
            value++;
            if (word.equals("heavens")) {
                System.out.println(word + " index " + value);
            }
        }
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Milli seconds to search: " + timeElapsed);

    }
}
