package org.interview.dailycodingproblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumFromTwoItemsInAList {

    /*
     Given a list of numbers and a number k, return whether any two numbers from
     the list add up to k. For example, given [10, 15, 3, 7] and k of 17,
     return true since 10 + 7 is 17.
     Bonus: Can you do this in one pass?
    */
    static public void main(String[] args) {
        int[] arr = {10,15,3,7};
        int total = 17;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            int diff = total - arr[i];
            if(map.containsKey(diff)) {
                System.out.printf("%d + %d = %d\n", arr[i], arr[map.get(diff)], total);
                break;
            }
            map.put(arr[i], i);
        }
    }
}
