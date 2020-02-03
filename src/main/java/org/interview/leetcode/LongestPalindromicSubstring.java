package org.interview.leetcode;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.isEmpty()) {
            return s;
        }
        String results = s.substring(0, 1);
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j < s.length(); j++) {
                if(isPalindrome(s.substring(i, j + 1))) {
                    if (results.length() <= j - i) {
                        results = s.substring(i, j + 1);
                    }
                }
            }
            if(results.length() > s.length() - i) {
                break;
            }
        }

        return results;
    }

    boolean isPalindrome(String s) {
        int len = s.length() - 1;
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(len - i)) {
                return false;
            }
        }
        return true;
    }

    static public void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("bb"));
    }
}