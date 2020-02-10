package org.interview.misc;

import java.util.Arrays;

public class ManachersAlgorithm {

    private String convertToSpecialString(String s) {
        StringBuilder sb = new StringBuilder();

        sb.append("@");
        for(char c : s.toCharArray()) {
            sb.append('#');
            sb.append(c);
        }
        sb.append("#$");
        return sb.toString();
    }

    public String findLongestPalindrome(String s) {
        if (s==null || s.length()==0)
            return "";

        String special = convertToSpecialString(s);
        int[] P = new int[special.length() + 2];
        int currentCenter = 0, rightLimit = 0;

        for(int i = 1; i< special.length() - 1; i++) {
            int mirror = currentCenter - (i - currentCenter);

            if (rightLimit > i) {
                P[i] = Math.min(rightLimit - i, P[mirror]);
            }

            while(special.charAt(i + 1 + P[i]) == special.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            if(i + P[i] > rightLimit) {
                currentCenter = i;
                rightLimit = i + P[i];
            }
        }

        int maxPalindrome = 0;
        int centerIndex = 0;

        for (int i = 1; i < special.length() - 1; i++) {

            if (P[i] > maxPalindrome) {
                maxPalindrome = P[i];
                centerIndex = i;
            }
        }

        System.out.println(maxPalindrome);
        int index = (centerIndex - 1 - maxPalindrome) / 2;
        return s.substring(index, index + maxPalindrome);
    }

    static public void main(String[] args) {
        ManachersAlgorithm o = new ManachersAlgorithm();
        System.out.println(o.findLongestPalindrome("kiomaramol"));
    }
}