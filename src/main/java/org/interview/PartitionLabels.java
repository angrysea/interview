package org.interview;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    List<Integer> doPartiion(String input) {
        List<Integer> results = new ArrayList<>();
        int[] lastIndex = new int[26];

        for(int i =0; i < input.length(); i++) {
            lastIndex[input.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while(i < input.length()) {
            int end = lastIndex[input.charAt(i) - 'a'];
            int j = i+ 1;
            while(j != end) {
                end = Math.max(end, lastIndex[input.charAt(j++) - 'a']);
            }
            results.add(j - i + 1);
            i = j + 1;
        }

        return results;
    }

    static public void main(String[] args) {
        String label = "ababcbacadefegdehijhklij";

        PartitionLabels o = new PartitionLabels();
        List<Integer> results = o.doPartiion(label);
    }

}
