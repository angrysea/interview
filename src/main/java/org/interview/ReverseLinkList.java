package org.interview;

public class ReverseLinkList<T> extends LinkedList<T> {

    public void reverse() {
        LinkedList.Node<T> prev = null;
        LinkedList.Node<T> current = root;
        LinkedList.Node<T> next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        root = prev;
    }

    public static void main(String[] args) {
        ReverseLinkList<Integer> list = new ReverseLinkList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println("Linked list");
        list.printList();
        System.out.println();
        list.reverse();
        System.out.println("Reversed list ");
        list.printList();
    }
}
