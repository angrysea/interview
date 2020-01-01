package org.interview.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class IntersectionOfTwoLinkedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode getIntersectNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) {
            return null;
        }

        Set<ListNode> set = new HashSet<>();
        ListNode currentB = headB;
        while(currentB != null) {
            set.add(currentB);
            currentB = currentB.next;
        }

        ListNode currentA = headA;

        while(currentA != null) {
            if(set.contains(currentA)) {
                return currentA;
            }
            currentA = currentA.next;
        }
        return null;
    }

    static public void main(String[] args) {
        IntersectionOfTwoLinkedLists o = new IntersectionOfTwoLinkedLists();
        ListNode rootA = new ListNode(10);
        ListNode rootB = new ListNode(20);

        ListNode currentA = rootA;
        ListNode currentB = rootB;

        for(int i = 1; i < 4; i++) {
            currentA.next = new ListNode(currentA.val + 1);
            currentA = currentA.next;

            currentB.next = new ListNode(currentB.val + 1);
            currentB = currentB.next;
        }

        currentA.next = new ListNode(30);

        currentB.next = currentA.next;
        currentA = currentA.next;
        for(int i = 1; i < 4; i++) {
            currentA.next = new ListNode(currentA.val + 1);
            currentA = currentA.next;
        }
        ListNode result = o.getIntersectNode(rootA, rootB);
        if(result == null) {
            System.out.println("No point of intersection.");
        }
        else {
            System.out.println("Point of intersection: " + result.val);
        }

    }
}
