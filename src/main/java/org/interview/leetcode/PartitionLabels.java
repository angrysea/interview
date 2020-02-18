package org.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    List<Integer> doPartition(String S) {
        List<Integer> results = new ArrayList<>();
        int[] lastIndex = new int[26];

        for(int i =0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while(i < S.length()) {
            int end = lastIndex[S.charAt(i) - 'a'];
            int j = i+ 1;
            while(j != end) {
                end = Math.max(end, lastIndex[S.charAt(j++) - 'a']);
            }
            results.add(j - i + 1);
            i = j + 1;
        }

        return results;
    }

    static public void main(String[] args) {
        String label = "ababcbacadefegdehijhklij";
        String label2 = "caedbdedda";

        PartitionLabels o = new PartitionLabels();
        o.doPartition(label2).stream().forEach(System.out::println);
    }
}