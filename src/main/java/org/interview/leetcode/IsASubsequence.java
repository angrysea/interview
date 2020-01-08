package org.interview.leetcode;

public class IsASubsequence {

    boolean checkIfSubsequence(String s, String t) {
        int len = s.length();
        if(len==0) {
            return true;
        }
        if(len > t.length()) {
            return false;
        }

        int index = 0;
        for (char c : t.toCharArray()) {
            if(s.charAt(index) == c) {
                index++;
            }
            if (index >= len) {
                return true;
            }
        }

        return false;
    }

    static public void main(String[] args) {
        IsASubsequence o = new IsASubsequence();
        String s = "abc", s2 = "axc", t = "ahbgdc";
        System.out.printf("%s %s a subsequence of %s.\n", s,
                o.checkIfSubsequence(s, t) ? "is" : "is not", t);
        System.out.printf("%s %s a subsequence of %s.\n", s2,
                o.checkIfSubsequence(s2, t) ? "is" : "is not", t);
    }
}
