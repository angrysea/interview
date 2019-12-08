package org.interview;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ReverseVowels {

    String reverse(String s) {
        Set<Character> vowels = new HashSet<>();
        "AaEeIiOoUuYy".chars().mapToObj(c -> (char)c).forEach(vowels::add);
        char[] string = s.toCharArray();
        int i = 0, j = string.length - 1;
        while(i < j) {
            while(i < j && !vowels.contains(string[i])) {
                i++;
            }
            while(i < j && !vowels.contains(string[j])) {
                j--;
            }

            char temp = string[i];
            string[i++] = string[j];
            string[j--] = temp;
        }

        return new String(string);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowels().reverse("leetcode"));
        System.out.println(new ReverseVowels().reverse("Albert"));
    }
}
