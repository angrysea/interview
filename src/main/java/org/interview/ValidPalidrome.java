package org.interview;

public class ValidPalidrome {

    boolean validate(final String s) {
        boolean isValid = false;
        int i = 0;
        int j = s.length() - 1;

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                if(s.charAt(i+1) == s.charAt(j)) {
                    i++;
                }
                else if(s.charAt(i) == s.charAt(j-1)) {
                    j--;
                }
                else {
                    return false;
                }
            }
            i++; j--;
        }
        return true;
    }


    boolean validate2(final String s) {
        boolean isValid = false;
        int i = 0;
        int j = s.length() - 1;

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j + 1);
            }
            i++; j--;
        }
        return false;
    }

    boolean isPalindrome(String s, int i, int j) {
        while(i<j) {
            if(s.charAt(i++) != s.charAt(j++)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalidrome o = new ValidPalidrome();
        System.out.printf("Paladeome? %b.", o.validate("abca"));
        System.out.println();
        System.out.printf("Paladeome? %b.", o.validate("rhino"));
        System.out.println();
        System.out.printf("Paladeome? %b.", o.validate("abccba"));
        System.out.println();
        System.out.printf("Paladeome? %b.", o.validate("abcdcba"));
        System.out.println();
        System.out.printf("Paladeome? %b.", o.validate("abcdcxba"));
        System.out.println();

    }
}
