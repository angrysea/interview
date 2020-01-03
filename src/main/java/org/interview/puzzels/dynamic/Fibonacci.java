package org.interview.puzzels.dynamic;

import java.util.Arrays;

public class Fibonacci {

    int fibRec(final int x) {
        if(x == 0) {
            return 0;
        }
        if(x == 1) {
            return 1;
        }
        return fibRec(x - 1) + fibRec(x - 2);
    }

    int fibDP(final int x) {
        int[]fib = new int[x + 1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2; i <= x; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[x];
    }

    public static void main(String[] args) {
        Fibonacci o = new Fibonacci();
        int i = 30;
        System.out.printf("Finonacci recursive of %d is %d.\n", i, o.fibRec(i));
        System.out.printf("Finonacci dynamic of %d is %d.\n", i, o.fibDP(i));
    }
}
