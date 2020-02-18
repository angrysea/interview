package org.interview.puzzels.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerPermutations {
    public List<int[]> permute(int[] nums) {
        List<int[]> results = new ArrayList<>();
        permutate(nums, 0, nums.length - 1, results);
        return results;
    }

    private void permutate(int[] arr, int left, int right, List<int[]> results) {
        if(left == right) {
            int[] premutation = new int[arr.length];
            System.arraycopy(arr, 0, premutation, 0, arr.length);
            results.add(premutation);
        }
        else {
            for(int i = left; i <= right; i++) {
                swap(arr, i, left);
                permutate(arr, left + 1, right, results);
                swap(arr, left, i);
            }
        }
    }

    private void  swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j] ^ (arr[j] = arr[i]);
    }


    public static void main(String[] args) {
        IntegerPermutations o = new IntegerPermutations();
        o.permute(new int[]{1,2,3,4}).stream().forEach( arr -> {
            for(int i : arr) {
                System.out.printf("%d, ", i);
            }
            System.out.println();
        });
    }
}
