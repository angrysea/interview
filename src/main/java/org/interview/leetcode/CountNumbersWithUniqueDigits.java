package org.interview.leetcode;

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        int total = 10;
        int uniqueNDigits = 9;

        for(int i = 2; i <= n; i++) {
            uniqueNDigits = uniqueNDigits * (10-i+1);
            total += uniqueNDigits;
        }
        return total;
    }

    public int countNumbersWithUniqueDigitsSlow(int n) {
        long max = (long)Math.pow(10, n);
        long nonUnique = 0;

        for (long i = 10; i < max; i++) {
            if(!areAllDigitsUnique(i)) {
                nonUnique++;
            }
        }
        return (int) (max - nonUnique);
    }

    boolean areAllDigitsUnique(long num) {
        boolean[] arr = new boolean[10];
        while (num > 0) {
            int digit = (int)(num % 10);
            if(arr[digit]) {
                return false;
            }
            arr[digit] = true;
            num /= 10;
        }

        return true;
    }

    public static void main(String[] args) {
        CountNumbersWithUniqueDigits o = new CountNumbersWithUniqueDigits();
        for (int i = 0; i < 10; i++) {
            System.out.println(o.countNumbersWithUniqueDigits(i));
        }
    }
}
