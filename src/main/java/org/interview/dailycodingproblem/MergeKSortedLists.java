package org.interview.dailycodingproblem;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    int[] mergeLists(int[][] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.stream(lists).forEach(list ->Arrays.stream(list).forEach(minHeap::add));
        int size = minHeap.size();
        int[] merged = new int[size];
        for(int i = 0; i < size; i++) {
            merged[i] = minHeap.poll();
        }
        return merged;
    }

    public static void main(String[] args) {
        int[][] lists = {{10, 15, 30}, {12, 15, 20}, {17, 20, 32}};
        MergeKSortedLists o = new MergeKSortedLists();

        System.out.println("Merged List:");
        Arrays.stream((o.mergeLists(lists))).forEach(i -> System.out.printf("%d, ", i));
    }
}