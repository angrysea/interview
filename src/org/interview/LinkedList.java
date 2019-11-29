public class LinkedList {
    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }

        Node(Node previous, int d) {
            data = d;
            previous.next = this;
        }
    }

    /* Function to reverse the linked list */
    private Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    // prints content of double linked list
    private void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        head = new Node(23);
        new Node(new Node(new Node(head,27),49),80);

        System.out.println("Linked list");
        list.printList(head);
        System.out.println();
        head = list.reverse(head);
        System.out.println("Reversed list ");
        list.printList(head);
    }
}
