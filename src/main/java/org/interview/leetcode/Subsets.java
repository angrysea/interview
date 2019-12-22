package org.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> getNoSubsets(int[]nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        getSubsets(0, nums, new ArrayList<Integer>(), subsets);
        return subsets;
    }

    void getSubsets(int index, int[]nums, List<Integer> current,
                    List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        for(int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            getSubsets(i + 1, nums, current, subsets);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets o = new Subsets();
        List<List<Integer>> results = o.getNoSubsets(new int[]{1, 2, 3});
        results.forEach(l -> {
            l.forEach(i -> System.out.printf("%d, ", i));
            System.out.println();
        });
    }
}
