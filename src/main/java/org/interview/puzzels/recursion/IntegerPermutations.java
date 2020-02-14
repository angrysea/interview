package org.interview.puzzels.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerPermutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i : nums) {
            list.add(i);
        }
        permutate(list, 0, nums.length - 1, results);
        return results;
    }

    private void permutate(List<Integer> list, int left, int right, List<List<Integer>> results) {
        if(left == right) {
            results.add(list);
        }
        else {
            for(int i = left; i <= right; i++) {
                permutate(swap(list, left, i), left + 1, right, results);
            }
        }
    }

    List<Integer> swap(List<Integer> l, int i, int j) {
        Integer temp;
        Integer[] arr = l.toArray(new Integer[l.size()]);
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return Arrays.asList(arr);
    }


    public static void main(String[] args) {
        IntegerPermutations o = new IntegerPermutations();
        o.permute(new int[]{1,2,3}).stream().forEach(System.out::println);
    }
}
