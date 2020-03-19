package org.interview.leetcode;

public class IntegerToRoman {
    public String intToRoman(int num) {
        if(num > 3999) {
            return null;
        }

        int[] values = new int[] {1000, 500, 100, 50, 10, 5, 1};
        char[] numerals = new char[] {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        StringBuilder sb = new StringBuilder();
        int max = values.length - 1;
        for(int i = 0; i <= max && num > 0; i++) {
            int n = num / values[i];
            num = num % values[i];
            if (n > 0) {
                if (n == 1) {
                    if (i < max && num / values[i + 1] > 3) {
                        sb.append(numerals[i + 1]);
                        sb.append(numerals[i - 1]);
                        num = num % values[i + 1];
                    } else {
                        sb.append(numerals[i]);
                    }
                } else if (n == 2 || n == 3) {
                    for (int j = 0; j < n; j++) {
                        sb.append(numerals[i]);
                    }
                } else {
                    sb.append(numerals[i]);
                    sb.append(numerals[i - 1]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman o = new IntegerToRoman();
        // I
        System.out.println(o.intToRoman(1));
        // NULL
        System.out.println(o.intToRoman(3999));
        // NULL
        System.out.println(o.intToRoman(4000));
        // MCMXCIV
        System.out.println(o.intToRoman(9));
        // MCMXCIV
        System.out.println(o.intToRoman(1994));
        // LVIII
        System.out.println(o.intToRoman(58));
    }
}
