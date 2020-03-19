package org.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> output = new ArrayList<>();
        if (S == null || S.isEmpty()) {
            return output;
        }
        helper(S, 0, "", output);
        return output;
    }

    void helper(String S, int idx, String current, List<String> output) {
        if (idx >= S.length()) {
            output.add(current);
        }
        else {
            int c = S.charAt(idx);
            if (!Character.isDigit(c)) {
                helper(S, idx + 1, current + (char)(c-32), output);
            }
            helper(S, idx + 1, current + (char)c, output);
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation o = new LetterCasePermutation();
        o.letterCasePermutation("a1b2").stream().forEach(System.out::println);
    }
}
