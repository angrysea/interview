package org.interview.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        if (nums.length == 1) {
            output.add(Collections.singletonList(nums[0]));
        }
        if (nums == null || nums.length < 2) {
            return output;
        }
        helper(nums, 0, nums.length, output);
        return output;
    }

    void helper(int[] nums, int left, int right, List<List<Integer>> output) {
        if (left >= right) {
            output.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        else {
            Set<Integer> alreadyProcessed = new HashSet<>();
            for(int i = left; i < right; i++) {
                if (!alreadyProcessed.contains(nums[i])) {
                    alreadyProcessed.add(nums[i]);
                    swap(nums, i, left);
                    helper(nums, left + 1, right, output);
                    swap(nums, left, i);
                }
            }
        }
    }

    static private void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b] ^ (arr[b] = arr[a]);
    }

    public static void main(String[] args) {
        PermutationsII o = new PermutationsII();
        o.permuteUnique(new int[]{1,2,3}).stream().forEach(l -> {
            l.stream().forEach(i -> System.out.printf("%d, ", i));
            System.out.println();
        });
    }
}
