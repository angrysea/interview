package org.interview.leetcode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class RepeatedDNA {
    List<String> findSubStrings(String s) {
        List<String> results = new ArrayList<>();
        if (s.length() < 10) {
            return results;
        }
        Map<String, Integer> found = new HashMap<>();
        StringBuilder sb = new StringBuilder(s.substring(0, 10));
        found.put(sb.toString(), 1);
        for(int i = 1; i <= s.length() - 10; i++) {
            sb.delete(0, 1);
            sb.append(s.charAt(i+9));
            String current = sb.toString();
            found.put(current, found.getOrDefault(current, 0) + 1);
        }
        return found.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        RepeatedDNA o = new RepeatedDNA();
        List<String> results = o.findSubStrings("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        results.forEach(System.out::println);
        results = o.findSubStrings("AAAAAAAAAAA");
        results.forEach(System.out::println);
    }
}
