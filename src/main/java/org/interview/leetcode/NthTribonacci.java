package org.interview.leetcode;

public class NthTribonacci {
    static public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n < 3) {
            return 1;
        }
        return tribonacciUtil(0, 1, 1, 2, n);
    }

    static int tribonacciUtil(int a, int b, int c, int current, int n) {
        if (current == n) {
            return c;
        }
        return tribonacciUtil(b, c, a + b + c, current + 1, n);
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }
}
