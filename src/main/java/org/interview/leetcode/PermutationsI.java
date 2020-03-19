package org.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationsI {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        helper(nums, 0, nums.length, output);
        return output;
    }

    void helper(int[] nums, int left, int right, List<List<Integer>> output) {
        if (left >= right) {
            output.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        else {
            for(int i = left; i < right; i++) {
                swap(nums, i, left);
                helper(nums, left + 1, right, output);
                swap(nums, left, i);
            }
        }
    }

    static private void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b] ^ (arr[b] = arr[a]);
    }

    public static void main(String[] args) {
        PermutationsI o = new PermutationsI();
        o.permute(new int[]{1,2,3}).stream().forEach(l -> {
                l.stream().forEach(i -> System.out.printf("%d, ", i));
            System.out.println();
        });
    }
}
