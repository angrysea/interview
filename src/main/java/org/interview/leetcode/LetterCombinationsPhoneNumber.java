package org.interview.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LetterCombinationsPhoneNumber {
    private static String[] letters = {"abc", "def", "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"};

    static public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits == null || digits.isEmpty()) {
            return combinations;
        }

        List<String> buttons = new ArrayList<>();
        for(char c : digits.toCharArray()) {
            int number = c - '0';
            if (number < 2 || number > 9) {
                continue;
            }
            buttons.add(letters[number - 2]);
        }

        getCombinationRecursive(buttons, 0, 0, "", combinations);
        return combinations;
    }

    static void getCombinationRecursive(List<String> buttons, int current, int index, String combination, List<String> combinations) {
        if (current >= buttons.size()) {
            combinations.add(combination.toString());
            return;
        }

        String button = buttons.get(current);
        for(int i = index; i < button.length(); i++) {
            getCombinationRecursive(buttons, current + 1, 0, combination + button.charAt(i), combinations);
        }
     }


    static Consumer<String> printString = (s) -> System.out.printf("%s, ", s);
    public static void main(String[] args) {
        letterCombinations("2").stream().forEach(printString);
        System.out.println();
    }
}
