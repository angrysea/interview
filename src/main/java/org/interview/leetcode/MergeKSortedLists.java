package org.interview.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    int[] mergeLists(ListNode[] lists) {
        final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(ListNode list : lists) {
            while(list != null) {
                minHeap.add(list.val);
                list = list.next;
            }
        }
        int size = minHeap.size();
        int[] merged = new int[size];
        for(int i = 0; i < size; i++) {
            merged[i] = minHeap.poll();
        }
        return merged;
    }

    ListNode mergeListNodes(ListNode[] lists) {
        int len = 0;
        final PriorityQueue<ListNode> minHeap = new PriorityQueue<>(10,
                (a, b) -> {if(a.val < b. val) return -1;
                            else if(a.val > b.val) return 1;
                            else return 0;});
        for(ListNode list : lists) {
            while(list != null) {
                minHeap.add(list);
                list = list.next;
            }
        }
        ListNode root = minHeap.poll();
        ListNode current = root;

        while(!minHeap.isEmpty()) {
            current.next = minHeap.poll();
            current = current.next;
        }
        current.next = null;
        return root;
    }
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(10);
        lists[0].next =  new ListNode(15);
        lists[0].next.next =  new ListNode(30);
        lists[0].next.next.next = null;
        lists[1] = new ListNode(12);
        lists[1].next = new ListNode(15);
        lists[1].next.next = new ListNode(20);
        lists[1].next.next.next = null;
        lists[2] = new ListNode(17);
        lists[2].next = new ListNode(20);
        lists[2].next.next = new ListNode(32);
        lists[2].next.next.next = null;

        MergeKSortedLists o = new MergeKSortedLists();
        System.out.println("Merged ListNode:");
        ListNode node = o.mergeListNodes(lists);
        while(node != null) {
            System.out.printf("%d, ", node.val);
            node = node.next;
        }
        System.out.println("Merged List:");
        Arrays.stream((o.mergeLists(lists))).forEach(i -> System.out.printf("%d, ", i));
    }
}