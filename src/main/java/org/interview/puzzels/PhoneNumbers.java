package org.interview.puzzels;

import java.util.*;

public class PhoneNumbers {

    private static String[] letters = {"abc", "def", "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"};


    static List<String> getLetterCombinations(String digits) {
        if(digits == null || digits.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        List<String> results = new LinkedList<>();
        List<String> list = new ArrayList(digits.length());

        for(int i = 0; i < digits.length(); i++) {
            int at = digits.charAt(i) - '0';
            if(at < 2 || at > 9) {
                continue;
            }
            list.add(letters[at - 2]);
        }

        int count = list.size();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< count; i++) {
            String s = list.get(i);
            max = Math.max(max, s.length());
        }

        char[][] buttons = new char[count][max];
        int[] lengths = new int[count];
        int sum = 1;
        for(int i = 0; i < count; i++) {
            String s = list.get(i);
            buttons[i] = s.toCharArray();
            lengths[i] = s.length();
            sum *= lengths[i];
        }

        int size = max * count;

        for (int i = 1; i <= max; i++) {
            sum *= count;
        }

        char[][] table = new char[sum][count];

        int row = 0, col = 0;
        for(int i = 0; i < count; i++) {
            for(int j = 0; j < lengths[count]; j++) {
                row = ((i+1) * (j+1)) - 1;
                for(int k = 0; k < max * count; k++) {
                    table[row][j] = buttons[i][j];
                }
            }
        }
//            for (int j = 0; j < max; j++) {
//                int position = 0;
//                while(position < size) {
//                    for(int j = 0; j < max; j++) {
//                    for (int l = j * max; l < (j * max) + max; l++) {
//                        table[l][i] = value.charAt(j);
//                    }
//                }
//            }
//        }

        return results;
    }

    public static void main(String[] args) {
        getLetterCombinations("127").stream().forEach(System.out::println);
        getLetterCombinations("23").stream().forEach(System.out::println);
        getLetterCombinations(" 7").stream().forEach(System.out::println);
        getLetterCombinations("2").stream().forEach(System.out::println);
    }
}
