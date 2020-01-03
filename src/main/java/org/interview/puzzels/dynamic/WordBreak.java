package org.interview.puzzels.dynamic;

import org.interview.trees.Trie;

import java.util.Arrays;
import java.util.Vector;
import java.util.stream.IntStream;

public class WordBreak {
    private final Trie dictionary;

    private WordBreak() {
        dictionary = new Trie();
    }

    private String breakWord(final String str) {
        String results = "";
        breakWord(str, str.length(), results);
        return results;
    }

    private void breakWord(final String str, int n, String result) {
        for (int i = 0; i < n; ++i) {
            String prefix = str.substring(0, i + 1);
            if (isWord(prefix)) {
                if (i == n) {
                    result += prefix;
                    System.out.println(result);
                    return;
                }
                breakWord(str.substring(i, n - i), n - i, result + prefix + " ");
            }
        }
    }

     private boolean breakWordDP(final String str) {
        final int size = str.length();
        if (size == 0) {
            return true;
        }

        boolean[] wb = new boolean[size + 1];
        Arrays.fill(wb, false);

        wb[0] = true;
        int count = 0;
        for (int i = 1; i <= size; i++) {
            String word = str.substring(0, i);

            if (wb[i] == false && isWord(word)) {
                wb[i] = true;
            }

            if (wb[i] == true) {
                for (int j = i + 1; j <= size; j++) {
                    count++;
                    word = str.substring(i, j);
                    System.out.printf("From %d to %d word: %s.\n", i, j, word);

                    if (wb[j] == false) {
                        wb[j] = isWord(word);
                    }
                    if (j == size && wb[j] == true) {
                        System.out.printf("Count: %d.\n", count);
                        return true;
                    }
                }
            }
        }
        System.out.printf("Count: %d.\n", count);
        return wb[size];
    }

    private boolean breakWordDP2(final String str) {
        final int size = str.length();
        if (size == 0) {
            return true;
        }

        boolean[] wb = new boolean[size + 1];
        Arrays.fill(wb, false);

        wb[0] = true;
        int count = 0;
        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < i; j++) {
                count++;
                String word = str.substring(j, i);
//                System.out.printf("From %d to %d word: %s.\n", j, i, word);

                if(wb[j]) {
                    System.out.printf("From %d to %d word: %s.\n", j, i, word);
                    wb[i] |= wb[j] && isWord(word);
                }
                else {
                    wb[i] = isWord(word);
                }

//                wb[i] |= wb[j] && isWord(word);
                if (wb[i]) {
                    System.out.printf("Found word: %s.\n", word);
                    break;
                }
            }
        }
        System.out.printf("Count: %d.\n", count);
        return wb[size];
    }

    private boolean isWord(final String word) {
        return dictionary.search(word);
    }

    private boolean canBeBrokenUp(final String str) {
        if (str.length() == 0) {
            return true;
        }

        for (int i = 1; i <= str.length(); i++) {
            final String prefix = str.substring(0, i);
            if (isWord(prefix) && canBeBrokenUp(str.substring(i))) {
                return true;
            }
        }
        return false;
    }

    private void insertWord(final String word) {
        dictionary.insert(word);
    }

    private void testWordBreak() {
        final String [] dictionary = {
                "mobile", "samsung", "sam", "sung", "man", "mango",
                "icecream", "and", "go", "i", "love", "ice", "cream"
        };

        Arrays.stream(dictionary).forEach(this::insertWord);

        final String test1 = "iloveicecreamandmango";
        System.out.printf("%s DP Test has %s.\n", test1, breakWordDP(test1) ? "passed" : "failed");

//        System.out.println("\nSecond DP Test: ");
//        if (breakWorddp("ilovesamsungmobile"))
//            System.out.println("pass.");
//        else
//            System.out.println("fail.");
//
//        System.out.println("\nThird DP Test: ");
//        if (breakWorddp("thiswillfail"))
//            System.out.println("pass.");
//        else
//            System.out.println("fail.");
//
//
//        final String test6 = "iloveicecreamandmango";
//        System.out.printf("Backtracking for %s : %s.", test6, breakWord(test6));
//
//        System.out.println("\nSecond Test:");
//        breakWord("ilovesamsungmobile");
    }

    // Word Break Problem
    private void testWordBreak2() {

        final String [] dictionary = {"this", "th", "is", "famous", "word", "break",
                "b", "r", "e", "a", "k", "br", "bre", "brea", "ak", "problem"};

        Arrays.stream(dictionary).forEach(this::insertWord);

        if (canBeBrokenUp("wordbreakproblem"))
            System.out.println("String can be segmented");
        else
            System.out.println("String can't be segmented");

        if (canBeBrokenUp("wordbreakproblemx"))
            System.out.println("String can be segmented");
        else
            System.out.println("String can't be segmented");
    }

    public static void main(String[] args) {
//        final String w = "wordbreakproblem";
//        for (int i = 0; i <= w.length(); i++) {
//            final String word = w.substring(0, i);
//            System.out.println(word);
//        }
//
        WordBreak wb = new WordBreak();
        wb.testWordBreak();
//        wb.testWordBreak2();
    }
}
