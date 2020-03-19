package org.interview.workout;

import java.util.HashSet;
import java.util.Set;

public class FindMissingNumber {

    static int findMissingNumber(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int item : numbers) {
            set.add(item);
        }

        for(int i = 0; i <= numbers.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    static int findMissingNumberFastest(int[] numbers) {
        if (numbers[0] != 0) {
            return 0;
        }

        int value = 0;
        for(int i = 1; i <= numbers.length; i++) {
            value ^= i;
        }

        for (int item : numbers) {
            value ^= item;
        }
        return value;
    }

    static int findMissingNumberBinary(int[] numbers) {
        if (numbers[0] != 0) {
            return 0;
        }

        int start = 0, end = numbers.length;
        while(start < end) {
            int middle = start + ((end - start) / 2);
            if(numbers[middle] == middle) {
                start = middle + 1;
            }
            else {
                if (numbers[middle - 1] == middle -1) {
                    return middle;
                }
                end = middle - 1;
            }
        }
        return end;
    }

    static int findMissingNumberRec(int[] numbers) {
        if (numbers[0] != 0) {
            return 0;
        }
        return findMissingHelper(0, numbers.length, numbers);
    }

    static int findMissingHelper(int start, int end, int [] numbers) {
        if(start >= end) {
            return end + 1;
        }

        int middle = start + ((end - start) / 2);
        if (numbers[middle] == middle) {
           return findMissingHelper(middle + 1, numbers.length - 1, numbers);
        }

        if (numbers[middle - 1] == middle - 1) {
            return middle;
        }
        return findMissingHelper(start, middle - 1, numbers);
    }

    public static void main(String[] args) {
        int[] numbers0 = {1,2,3};
        System.out.printf("1,2,3 The missing number is: %d.\n", findMissingNumber(numbers0));
        int[] numbers = {0,1,2};
        System.out.printf("0,1,2 The missing number is: %d.\n", findMissingNumber(numbers));
        int[] numbers2 = {0,1,3,4};
        System.out.printf("0,1,3,4 The missing number is: %d.\n", findMissingNumber(numbers2));
        int[] numbers3 = {0,1,2,3,4,6,7,8,9,10};
        System.out.printf("0,1,2,3,4,6,7,8,9,10 The missing number is: %d.\n", findMissingNumber(numbers3));
    }
}
