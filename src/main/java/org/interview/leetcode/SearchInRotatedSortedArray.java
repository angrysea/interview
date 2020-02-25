package org.interview.leetcode;

import java.nio.file.attribute.UserDefinedFileAttributeView;

public class SearchInRotatedSortedArray {
    static public int search(int[] nums, int target) {
        if(nums == null || nums.length < 1) {
            return -1;
        }

        int middle = 0, start = 0, end = nums.length - 1;
        while (start < end) {
            middle = start + (end - start) / 2;
            if (nums[middle] > nums[end]) {
                start = middle + 1;
            }
            else {
                end = middle;
            }
        }

        end = nums.length - 1;
        int startHold = start;
        start = 0;
        if(target >= nums[startHold] && target <= nums[end]) {
            start = startHold;
        }
        else {
            end = startHold;
        }


        while (start <= end) {
            middle = start + ((end - start) / 2);
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
//        int[] nums = {1};
        for(int i = 0; i < nums.length; i++) {
            System.out.printf("Index %d for %d.\n", search(nums, nums[i]), nums[i]);
        }
    }
}
