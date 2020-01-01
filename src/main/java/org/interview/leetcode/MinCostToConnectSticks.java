package org.interview.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostToConnectSticks {
    int connectSticks(int[] sticks) {
        int totalCost = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        Arrays.stream(sticks).forEach(i -> queue.add(i));
        while(queue.size() > 1) {
            int sum = queue.poll()+ queue.poll();
            queue.add(sum);
            totalCost += (sum);
        }

        return totalCost;
    }


    static public void main(String[] args) {
        MinCostToConnectSticks o = new MinCostToConnectSticks();
        System.out.printf("The cost to connect the sticks is %d.\n",
                o.connectSticks(new int[]{1,8,3,5}));
    }
}
