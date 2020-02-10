package org.interview.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, count = 0, len = s.length(), start = 0, end = 0;
        Map<Character, Integer> found = new HashMap<>();

        while(start < len && len - start > max) {
            while(end < len && found.getOrDefault(s.charAt(end), 0) == 0) {
                found.put(s.charAt(end), found.getOrDefault(s.charAt(end), 0) + 1);
                end++;
                count++;
            }
            max = Math.max(max, count);
            count--;
            found.put(s.charAt(start), found.getOrDefault(s.charAt(start), 0) - 1);
            start++;
        }
        return max;
    }

    static public void main(String[] args) {
        System.out.println(new LongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }
}
