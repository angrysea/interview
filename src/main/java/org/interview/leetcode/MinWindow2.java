package org.interview.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinWindow2 {

    public String minWindow(String s, String t) {
        Map<Character, Integer> requiredCharacters = new HashMap<>();
        for (char c : t.toCharArray()) {
            requiredCharacters.put(c,  requiredCharacters.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int charsToMatch = requiredCharacters.size();
        int charInWindowToMatch = 0;
        int currMinWindowLen = Integer.MAX_VALUE;
        String minWindow = "";
        Map<Character, Integer> windowMapping = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowMapping.put(rightChar,
                    windowMapping.getOrDefault(rightChar, 0) + 1);
            if (requiredCharacters.containsKey(rightChar) &&
                    requiredCharacters.get(rightChar).equals(windowMapping.get(rightChar))) {
                charInWindowToMatch++;
            }

            while (charInWindowToMatch == charsToMatch && left <= right) {
                char leftChar = s.charAt(left);
                int windowSize = right - left + 1;
                if (windowSize < currMinWindowLen) {
                    currMinWindowLen = windowSize;
                    minWindow = s.substring(left, right + 1);
                }

                windowMapping.put(leftChar, windowMapping.get(leftChar) - 1);
                boolean leftCharIsARequirement = requiredCharacters.containsKey(leftChar);
                if (requiredCharacters.containsKey(leftChar) &&
                        windowMapping.get(leftChar).intValue() < requiredCharacters.get(leftChar).intValue()) {
                    charInWindowToMatch--;
                }
                left++;
            }
            right++;
        }
        return minWindow;
    }

    static public void main(String[] args) {
        MinWindow2 o = new MinWindow2();
        String s = "ADAOBECODEBANC";
        String t = "ABC";
        System.out.println(o.minWindow(s, t));
    }
}
