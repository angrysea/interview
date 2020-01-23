package org.interview.leetcode;

import java.util.Stack;

public class BackspaceStrings {
    boolean compareToStrings(final String s1, final String s2) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(char c : s1.toCharArray()) {
            if (!stack1.isEmpty() && c == '#') {
                stack1.pop();
            }
            else {
                stack1.push(c);
            }
        }

        for(char c : s2.toCharArray()) {
            if (!stack2.isEmpty() && c == '#') {
                stack2.pop();
            }
            else {
                stack2.push(c);
            }
        }

        if(stack1.size() == stack2.size()) {
            while(!stack1.isEmpty()) {
                if(stack2.isEmpty() || stack1.pop() != stack2.pop()) {
                    return false;
                }
            }
        }

        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        BackspaceStrings o = new BackspaceStrings();
        final String s1 = "abz#c";
        final String s2 = "ax#bcz#";
        final String s3 = "adx#bcz#";
        System.out.printf("String %s and %s are %s.\n", s1, s2,
                o.compareToStrings(s1, s2) ? "equals" : "are not equal");
        System.out.printf("String %s and %s are %s.\n", s1, s3,
                o.compareToStrings(s1, s3) ? "equal" : "are not equal");
    }
}
