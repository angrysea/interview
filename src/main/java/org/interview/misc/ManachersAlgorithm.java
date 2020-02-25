package org.interview.misc;

import java.util.Arrays;

public class ManachersAlgorithm {
    public String findLongestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";

        char[] s2 = addBoundaries(s.toCharArray());
        int[] p = new int[s2.length];
        int center = 0, rightMost = 0; // Here the first element in s2 has been processed.

        for (int i = 1; i < s2.length; i++) {
            int mirror = center - (i - center);
            if (i < rightMost) {
                p[i] = Math.min(rightMost - i, p[mirror]);
            }

            int right = i + (p[i] + 1);
            int left = i - (p[i] + 1);
            while (right < s2.length && left >= 0 && s2[left] == s2[right]) {
                p[i]++;
                right++;
                left--;
            }
            if (i + p[i] > rightMost) {
                center = i;
                rightMost = i + p[i];
            }
        }

        int maxLength = 0;
        int index = 0;
        for(int i = 0; i < p.length; i++) {
            if(p[i] > maxLength) {
                maxLength = p[i];
                index = i;
            }
        }
        char[] ss = Arrays.copyOfRange(s2, index - maxLength, index + maxLength + 1);

        return String.valueOf(removeBoundaries(ss));
    }

    private char[] addBoundaries(char[] cs) {
        if (cs==null || cs.length==0)
            return "||".toCharArray();

        char[] cs2 = new char[cs.length*2+1];
        for (int i = 0; i<(cs2.length-1); i = i+2) {
            cs2[i] = '#';
            cs2[i+1] = cs[i/2];
        }
        cs2[cs2.length-1] = '#';
        return cs2;
    }

    private char[] removeBoundaries(char[] cs) {
        if (cs==null || cs.length<3)
            return "".toCharArray();

        char[] cs2 = new char[(cs.length-1)/2];
        for (int i = 0; i<cs2.length; i++) {
            cs2[i] = cs[i*2+1];
        }
        return cs2;
    }

    static public void main(String[] args) {
        ManachersAlgorithm o = new ManachersAlgorithm();
        System.out.println(o.findLongestPalindrome("bananas"));
    }
}
