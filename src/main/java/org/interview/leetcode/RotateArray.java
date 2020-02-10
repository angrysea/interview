package org.interview.leetcode;

import java.util.Arrays;

public class RotateArray {
    public int[] rotate(int[] nums, int k) {

        for(int i = 0; i < k; i++) {
            int hold = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = hold;
        }
        return nums;
    }

    public static void main(String[] args) {
        RotateArray o = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        Arrays.stream(o.rotate(nums, k)).forEach(i -> System.out.printf("%d, ", i));
    }
}