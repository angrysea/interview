package org.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PhoneNumbers {

    private static String[] letters = {"abc", "def", "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"};


    static List<String> getLetterCombinations(String numbers) {
        List<String> results = new LinkedList<>();
        if(numbers == null || numbers.length() != 2) {
            return Collections.emptyList();
        }
        int at = numbers.charAt(0) - '0';
        if(at < 2 || at > 9) {
            return Collections.emptyList();
        }
        String a = letters[at-2];

        at = numbers.charAt(1) - '0';
        if(at < 2 || at > 9) {
            return Collections.emptyList();
        }
        String b = letters[at-2];

        for(int i = 0; i < a.length(); i++) {
            for(int j = 0; j < b.length(); j++) {
                results.add("" + a.charAt(i) + b.charAt(j));
            }
        }

        return results;
    }

    public static void main(String[] args) {
        getLetterCombinations("27").stream().forEach(System.out::println);
    }
}
