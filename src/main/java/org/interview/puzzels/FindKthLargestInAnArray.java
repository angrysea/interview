package org.interview.puzzels;

import java.util.PriorityQueue;

public class FindKthLargestInAnArray {

    int find(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i : nums) {
            minHeap.add(i);
            if(minHeap.size() > k) {
                minHeap.remove();
            }
         }
        return minHeap.poll();
    }

    static public void main(String[] args) {
        int[] data = {3,2,1,5,6,4};
        int k = 3;
        FindKthLargestInAnArray p = new FindKthLargestInAnArray();
        System.out.println(p.find(data, k));
    }

}
