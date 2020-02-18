package org.interview.leetcode;

import java.util.Set;
import java.util.HashSet;

public class LinkedListCycleII {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode current = head.next;
        while(current != null) {
            if(current.val == head.val) {
                if(!set.contains(current.val)) {
                    return false;
                }
            }
            if(set.contains(current.val)) {
                return true;
            }
            set.add(current.val);
            current = current.next;
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        int swap = 0;
        ListNode current = head;
        while(current != null) {
            int value = swap;
            swap ^= current.val;
            if(value - swap == current.val) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedListCycleII o = new LinkedListCycleII();
        ListNode head = new ListNode(3);
        ListNode current = head;
        for(int i : new int[]{2,0,4}) {
            current.next = new ListNode(i);
            current = current.next;
        }
        current.next = head.next;
        o.hasCycle(head);
//        ListNode results = o.detectCycle(head);
    }
}
