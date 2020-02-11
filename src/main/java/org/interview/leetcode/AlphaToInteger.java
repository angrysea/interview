package org.interview.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;

public class AlphaToInteger {

    static int myAtoi(String str) {
        if(str.length()==0)
            return 0;

        int value = 0;

        char[] s = str.toCharArray();
        int i = 0;
        for(; i < str.length() && s[i] == ' '; i++);

        boolean isNegative = false;
        if( i < str.length() && (s[i] == '-' || s[i] == '+')) {
            if(s[i] == '-') {
                isNegative = true;
            }
            i++;
        }

        Predicate<Character> isNotNumber = c -> (c < '0' || c > '9');
        Queue<Integer> numbers = new LinkedList<>();
        for(; i < str.length(); i++) {
            if (isNotNumber.test(s[i])) {
                break;
            }
            numbers.add(s[i] - '0');
        }

        int max = Integer.MAX_VALUE % 10 + Integer.MAX_VALUE / 10;
        int min = (Integer.MIN_VALUE % 10 * -1) + Integer.MIN_VALUE / -10;

        while(!numbers.isEmpty()) {
            int n = numbers.poll();
            if ((isNegative && min < n + value) || max < n + value) {
                if(isNegative) {
                    return Integer.MIN_VALUE;
                }
                else {
                    return Integer.MAX_VALUE;
                }
            } else {
                value = value * 10 + n;
            }
        }
        if (isNegative) {
            value *= -1;
        }
        return value;
    }

    public static void main(String[] args) {

        System.out.println(myAtoi("-2147483647"));
        System.out.println(myAtoi("2147483646"));
        System.out.println(myAtoi(" "));
        System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("-42"));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("-2147483649"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("-91283472332"));
    }
}