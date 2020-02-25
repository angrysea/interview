package org.interview.leetcode;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class FindFirstAndLast {
    static int[] searchRange(int[] nums, int target) {
        int[] firstLast = new int[2];
        firstLast[0] = -1;
        firstLast[1] = -1;
        if (nums == null || nums.length == 0) {
            return firstLast;
        }

        findFirstRange(nums, target, 0, nums.length - 1, firstLast);

        return firstLast;
    }

    static void findFirstRange(int[] nums, int target, int start, int end, int[] firstLast) {
        if (start > end) {
            return;
        }

        int middle = start + ((end - start) / 2);
        if (nums[middle] == target) {
            int first = 0, last = end;
            int i;
            for(i = middle - 1; i >=0; i--) {
                if (nums[i] < target) {
                    first =  i + 1;
                    break;
                }
            }
            for(i = middle + 1; i <= end; i++) {
                if (nums[i] > target) {
                    last =  i - 1;
                    break;
                }
            }
            firstLast[0] = first;
            firstLast[1] = last;
            return;
        }
        else if (nums[middle] > target) {
            findFirstRange(nums, target, start, middle - 1, firstLast);
        }
        else {
            findFirstRange(nums, target, middle + 1, end, firstLast);
        }
    }

    static IntConsumer printInt = (i) -> System.out.printf("%d, ", i);
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        Arrays.stream(searchRange(nums, 8)).forEach(printInt);
        System.out.println();
        Arrays.stream(searchRange(nums, 10)).forEach(printInt);
        System.out.println();
        Arrays.stream(searchRange(nums, 5)).forEach(printInt);
        System.out.println();
        Arrays.stream(searchRange(nums, 6)).forEach(printInt);
        System.out.println();
    }
}