package org.interview.leetcode;

public class IsSubsequence {
    boolean isSub(final String s, final String t) {
        for(int i = 0, j = 0; i < t.length(); i++) {
            if(t.charAt(i) == s.charAt(j)) {
                j++;
            }
            if(j>=s.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsSubsequence o = new IsSubsequence();
        String s = "abc";
        String t = "ahbgdc";
        System.out.printf("%s %s a subsequence of %s\n" +
                        "", s,
                (o.isSub(s, t) == true ? "is" : "isn't"), t);
        s = "axbc";
        System.out.printf("%s %s a subsequence of %s", s,
                (o.isSub(s, t) == true ? "is" : "isn't"), t);
    }
}