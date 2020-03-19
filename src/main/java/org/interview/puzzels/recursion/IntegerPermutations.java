package org.interview.puzzels.recursion;

import java.util.ArrayList;
import java.util.List;

public class IntegerPermutations {
    public List<int[]> permutations(int[] nums) {
        List<int[]> results = new ArrayList<>();
        permutation(nums, 0, nums.length - 1, results);
        return results;
    }

    private void permutation(int[] arr, int left, int right, List<int[]> results) {
        if(left == right) {
            int[] permutation = new int[arr.length];
            System.arraycopy(arr, 0, permutation, 0, arr.length);
            results.add(permutation);
        }
        else {
            for(int i = left; i <= right; i++) {
                swap(arr, i, left);
                permutation(arr, left + 1, right, results);
                swap(arr, left, i);
            }
        }
    }

    private void  swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j] ^ (arr[j] = arr[i]);
    }


    public static void main(String[] args) {
        IntegerPermutations o = new IntegerPermutations();
        o.permutations(new int[]{1,2,3,4}).stream().forEach( arr -> {
            for(int i : arr) {
                System.out.printf("%d, ", i);
            }
            System.out.println();
        });
    }
}
