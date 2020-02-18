package org.interview.workout;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public boolean canBreakupIntoWords(String s, List<String> dictionary) {
        boolean[] found = new boolean[s.length() + 1];
        found[0] = true;

        int count = 0, lookups = 0;
        for(int i = 1; i <= s.length(); i++) {
            String current = s.substring(0, i);

            count++;
            if (found[i] == false && dictionary.contains(current)) {
                lookups++;
                found[i] = true;
            }

            if (found[i] == true) {
                for (int j = i + 1; j <= s.length(); j++) {
                    current = s.substring(i, j);
                    count++;
                    if (found[j] == false) {
                        found[j] = dictionary.contains(current);
                        lookups++;
                    }

                    if (j == s.length() && found[j] == true) {
                        return true;
                    }
                }
            }
        }
        System.out.println("count: " + count + ", lookups: " + lookups);
        return found[s.length()];
    }

    public boolean canBreakupIntoWordsRecursive(String s, List<String> dictionary, List<String> results) {
        if(s.isEmpty()) {
            return true;
        }

        for(int i = 1; i <= s.length(); i++) {
            String current = s.substring(0, i);
            if(dictionary.contains(current) &&  canBreakupIntoWordsRecursive(s.substring(i), dictionary, results)) {
                results.add(current);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        List<String> dictionary = Arrays.asList(new String[]{
                "mobile", "samsung", "sam", "sung", "man", "mango",
                "icecream", "and", "go", "i", "love", "ice", "cream"
        });

        WordBreak o = new WordBreak();
        final String test1 = "iloveicecreamandmango";
        System.out.printf("%s DP Test has %s.\n", test1, o.canBreakupIntoWords(test1, dictionary) ? "passed" : "failed");
        final List<String> dictionary2 = Arrays.asList(new String[] {"cats", "dog", "sand", "and", "cat"});
        final String test2 = "catsandog";
        System.out.printf("%s DP Test has %s.\n", test2, o.canBreakupIntoWords(test2, dictionary2) ? "passed" : "failed");

    }
}
