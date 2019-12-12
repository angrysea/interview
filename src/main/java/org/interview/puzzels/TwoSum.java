package org.interview.puzzels;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private int[] findTwo(final int[] arr, final int sum) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            int difference = sum - arr[i];
            if(map.containsKey(difference)) {
                ret[0] = i;
                ret[1] = map.get(difference);
                break;
            }
            map.put(arr[i], i);
        }

        return ret;
    }

    public static void main(String[] args) {
        final int[] values = {2, 7, 11, 15, 12, 32};
        int[] ret = new TwoSum().findTwo(values, 14);
        System.out.println(ret[0] + " " + ret[1]);
        ret = new TwoSum().findTwo(values, 18);
        System.out.println(ret[0] + " " + ret[1]);
        ret = new TwoSum().findTwo(values, 9);
        System.out.println(ret[0] + " " + ret[1]);
    }
}
