package org.interview.leetcode;

import javax.crypto.spec.PSource;

public class RemovePalindromicSequences {

    static int minimumRemovals(String s) {
        if (s==null || s.isEmpty()) {
            return 0;
        }
        for(int i = 0, j = s.length() -1; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return 2;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(minimumRemovals("baabb"));
        System.out.println(minimumRemovals("bbbaaabaaabbb"));
    }
}
