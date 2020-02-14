package org.interview.puzzels.recursion;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class AllStringPermutations {
    private void permutate(String s, int left, int right, List<String> results) {
        if(left == right) {
            results.add(s);
        }
        else {
            for(int i = left; i <= right; i++) {
                permutate(swap(s, left, i), left + 1, right, results);
            }
        }
    }

    String swap(String s, int i, int j) {
        char temp;
        char[] arr = s.toCharArray();
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }


    List<String> getPermutations(String s) {
        List<String> results = new ArrayList<>();
        permutate(s, 0, s.length() - 1, results);
        return results;
    }

    public static void main(String[] args) {
        AllStringPermutations o = new AllStringPermutations();
        o.getPermutations(("ABC")).stream().forEach(System.out::println);
    }
}
