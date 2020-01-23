package org.interview.leetcode;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];

        for(int i = 0; i < nums.length; i++) {
            ++counts[nums[i]];
        }

        for(int i = 0, j = 0; i < counts.length; i++) {
            for(int k = 0; k < counts[i]; k++) {
                nums[j++] = i;
            }
        }
    }

    public static void main(String args[]) {
        SortColors o = new  SortColors();
        int[] nums = {2,0,2,1,1,0};
        Arrays.stream(nums).forEach(i -> System.out.printf("%d, ", i));
        System.out.println();
        o.sortColors(nums);
        Arrays.stream(nums).forEach(i -> System.out.printf("%d, ", i));
    }
}
