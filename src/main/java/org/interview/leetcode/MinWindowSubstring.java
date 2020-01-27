package org.interview.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public String minWindow(String s, String t) {
        String response = "";
        Map<Character, Integer> chars = new HashMap<>();
        Map<Character, Integer> word = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            chars.put(t.charAt(i), chars.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            word.put(t.charAt(i), 0);
        }

        int min = Integer.MAX_VALUE;
        int found = 0, start = 0, end = 0;
        int needed = t.length();

        while(end < s.length()) {
            Character c = s.charAt(end);
            if(chars.containsKey(c)) {
                word.put(c, word.get(c) + 1);
                if(chars.get(c) >= word.get(c)) {
                    found++;
                }
            }

            while(start <= end && found == needed) {
                min = Math.min(min, end - start);
                if (min == end - start) {
                    response = s.substring(start, end + 1);
                }
                c = s.charAt(start++);
                if(chars.containsKey(c)) {
                    word.put(c, word.get(c) - 1);
                    if(word.get(c) < chars.get(c)) {
                        found--;
                    }
                }
            }
            end++;
        }
        return response;
    }

    public static void main(String[] args) {
        MinWindowSubstring o = new MinWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.printf("Min window for %s of %s is %s.\n", s, t, o.minWindow(s, t));
    }
}