package org.interview.leetcode;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        if(A == null || A.isEmpty() || B == null || B.isEmpty()) {
            return -1;
        }
        int max = 0;
        if (A.length() > B.length()) {
            max = A.length() * 2;
        }
        else {
            max = A.length() * ((B.length() / A.length()) + 2);
        }

        for(int i = 0, j = 0; i < max; i++, j++) {
            if(j == A.length()) {
                j = 0;
            }
            if(B.charAt(0) == A.charAt(j)) {
                int k = 1;
                for(int l = j + 1; k < B.length() && k < max - i; k++, l++) {
                    if(l == A.length()) {
                        l = 0;
                    }
                    if(B.charAt(k) != A.charAt(l)) {
                        break;
                    }
                }
                if (k == B.length()) {
                    int total = i + k;
                    return total / A.length() + (total % A.length() == 0 ? 0 : 1);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RepeatedStringMatch o = new RepeatedStringMatch();
        final String A = "abc";
        final String B = "cabcabca";
        System.out.println(o.repeatedStringMatch(A, B));
    }
}
