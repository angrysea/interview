package org.interview.leetcode;

import java.util.Comparator;

public class IsMonotonicArray {

    boolean isMonotonic(int[] values) {
        if(values.length < 2) {
            return false;
        }

        Comparator<Integer> check = (a, b) -> { return a - b; };
        if(values[0] - values[1] <= 0) {
            check = (a, b) -> { return b - a; };
        }

        for(int i = 2; i < values.length; i++) {
            if(check.compare(values[i - 1], values[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    static public void main(String[] args) {
        IsMonotonicArray o = new IsMonotonicArray();
        System.out.printf("Is monotonic: %b.\n", o.isMonotonic(new int[]{1,2,2,3}));
        System.out.printf("Is monotonic: %b.\n", o.isMonotonic(new int[]{6,5,4,4}));
        System.out.printf("Is monotonic: %b.\n", o.isMonotonic(new int[]{1,3,2}));
        System.out.printf("Is monotonic: %b.\n", o.isMonotonic(new int[]{1,2,4,5}));
        System.out.printf("Is monotonic: %b.\n", o.isMonotonic(new int[]{1,1,1,1}));
    }
}
