package org.interview.leetcode;

import java.util.*;

public class FindMostCommonInteger {

    int findMostCommon(int[] arr) {
        Map<Integer, Integer> ints = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            ints.put(arr[i], ints.getOrDefault(arr[i], 0) + 1);
        }

        int max = 0, most = 0;
        for(Map.Entry<Integer, Integer> entry : ints.entrySet()) {
            if(entry.getValue() > max) {
                most = entry.getKey();
                max = entry.getValue();
            }
        }
        return most;
    }

    void findSumsOfN(int[] arr, int n) {
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            if(s.contains(n - arr[i])) {
                System.out.printf("%d + %d = %d\n", arr[i], n-arr[i], n);
                s.remove(n - arr[i]);
            }
            else {
                s.add(arr[i]);
            }
        }
    }

    void findSumsOfNTwo(int[] arr, int n) {
        int start = 0, end = arr.length - 1;
        Arrays.sort(arr);
        while(start <= arr.length / 2) {
            int sum = arr[start] + arr[end];
            if(sum == n) {
                System.out.printf("%d + %d = %d\n", arr[start],
                        arr[end], n);
                end--;
                start++;
            }
            if(sum > n) {
                end--;
            }
            else {
                start++;
            }
        }
    }

    static public void main(String[] args) {
        FindMostCommonInteger o = new FindMostCommonInteger();
        int[] arr = new int[] { 1,2,3,57,3};
        System.out.println(o.findMostCommon(arr));
        arr = new int[] {1,9,1,5,5};
        o.findSumsOfNTwo(arr, 10);
    }
}
