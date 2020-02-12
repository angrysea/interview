package org.interview.leetcode;

import java.util.Stack;

public class ReverseInteger {

    static int reverseInt(int n) {
        if(n < 10) {
            return n;
        }
        Stack<Integer> queue = new Stack<>();
        while(n > 0) {
            queue.push(n % 10);
            n /= 10;
        }

        int reversed = 0;
        int factor = 1;
        while(!queue.isEmpty()) {
            reversed = reversed + (queue.pop() * factor);
            factor *= 10;
        }

        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverseInt(123));
    }
}
