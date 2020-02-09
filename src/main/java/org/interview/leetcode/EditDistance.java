package org.interview.leetcode;

import java.util.Arrays;

/*
    Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

    You have the following 3 operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character

    Levenshtein's edit distance algorithm
 */
public class EditDistance {

    void swap(int[] a, int[] b) {
    }

    public int minDistance(String word1, String word2) {
        if(word1 == null || word1.isEmpty()) {
            return word2 == null ? 0 : word2.length();
        }

        if(word2 == null || word2.isEmpty()) {
            return word1 == null ? 0 : word1.length();
        }

        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for(int row = 0; row <= word1.length(); row++) {
            dp[row][0] = row;
        }

        for(int col = 0; col <= word2.length(); col++) {
            dp[0][col] = col;
        }

        for(int row = 1; row <= word1.length(); row++) {
            for (int col = 1; col <= word2.length(); col++) {
                dp[row][col] = dp[row-1][col-1];
                if(word1.charAt(row - 1) != word2.charAt(col - 1)) {
                    dp[row][col] = Math.min(dp[row][col], Math.min(dp[row-1][col], dp[row][col-1])) + 1;
                }
            }
        }

        Arrays.stream(dp).forEach(row -> {
            Arrays.stream(row).forEach(i -> System.out.printf("%d, ", i));
            System.out.println();
        });
        return dp[word1.length()][word2.length()];
    }

     public static void main(String[] args) {

        EditDistance o = new EditDistance();
        String word1 = "horse", word2 = "ros";
        System.out.printf("%d operations required to change %s to %s.\n", o.minDistance(word1, word2), word1, word2);
        word1 = "intention"; word2 = "execution";
        System.out.printf("%d operations required to change %s to %s.\n", o.minDistance(word1, word2), word1, word2);
        word1 = "sitting"; word2 = "kitten";
        System.out.printf("%d operations required to change %s to %s.\n", o.minDistance(word1, word2), word1, word2);
    }
}
