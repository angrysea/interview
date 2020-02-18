package org.interview.puzzels.recursion;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class AllStringPermutations {
    private void swap(char[] arr, int i, int j) {
        arr[i] = (char) (arr[i] ^ arr[j] ^ (arr[j] = arr[i]));
    }

    private void permutate(char[] s, int left, int right, List<String> results) {
        if(left == right) {
            results.add(String.valueOf(s));
        }
        else {
            for(int i = left; i <= right; i++) {
                swap(s, left, i);
                permutate(s, left + 1, right, results);
                swap(s, i, left);
            }
        }
    }

    List<String> getPermutations(String s) {
        List<String> results = new ArrayList<>();
        permutate(s.toCharArray(), 0, s.length() - 1, results);
        return results;
    }

    public static void main(String[] args) {
        AllStringPermutations o = new AllStringPermutations();
        o.getPermutations(("ABC")).stream().forEach(System.out::println);
    }
}
