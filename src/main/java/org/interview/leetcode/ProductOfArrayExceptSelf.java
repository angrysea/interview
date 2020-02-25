package org.interview.leetcode;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class ProductOfArrayExceptSelf {
    static IntBinaryOperator getProduct = (a,b) -> a * b;

    static int[] productsOfArrayExcept(int[] nums) {
        if(nums.length < 1) {
            return nums;
        }

        int[] results = new int[nums.length];

        results[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            results[i] = results[i + 1] * nums[i + 1];
        }
        int right = 1;
        for(int i = 0; i < nums.length; i++) {
            if (i > 0) {
                right = right * nums[i - 1];
            }
            results[i] = right * results[i];
        }
        return results;
    }

    public static void main(String[] args) {
        Arrays.stream(productsOfArrayExcept(new int[]{4}))
                .forEach(i -> System.out.printf("%d, ", i));
        System.out.println();
        Arrays.stream(productsOfArrayExcept(new int[]{4,5,1,8,2}))
                .forEach(i -> System.out.printf("%d, ", i));
        System.out.println();
    }
}
