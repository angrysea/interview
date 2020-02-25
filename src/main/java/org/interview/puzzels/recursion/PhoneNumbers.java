package org.interview.puzzels.recursion;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PhoneNumbers {

    private static String[] mappings = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> getLetterCombinations(String numbers) {
        List<String> results = new LinkedList<>();
        if (numbers == null) {
            return Collections.emptyList();
        }
        letterCombinations(results, numbers, "", 0, mappings);
        return results;
    }

    void letterCombinations(List<String> results, String numbers, String current, int index, String[] mappings) {
        if(index == numbers.length()) {
            results.add(current);
            return;
        }

        int at = numbers.charAt(index) - '0';
        if(at < 2 || at > 9) {
            letterCombinations(results, numbers, current, index+1, mappings);
            return;
        }

        String letters = mappings[at-2];
        for(int i = 0; i < letters.length(); i++) {
            letterCombinations(results, numbers, current + letters.charAt(i), index+1, mappings);
        }
    }

    public static void main(String[] args) {
        new PhoneNumbers().getLetterCombinations("8273").forEach(System.out::println);
    }
}
