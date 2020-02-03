package org.interview.bits;

/*
 * http://graphics.stanford.edu/~seander/bithacks.html
 */
public class BitTwiddlingHacks {
    static boolean isNegative(final int n) {
        return (n >> (Integer.BYTES - 1) == -1);
    }

    static boolean oppositeSigns(final int a, final int b) {
        return ((a ^ b) < 0);
    }

    static int findMin(final int x, final int y) {
        return y ^ ((x ^ y) & -(x < y ? 1 : 0));
    }
    static int findMax(final int x, final int y) {
        return x ^ ((x ^ y) & -(x < y ? 1 : 0));
    }

    static int countBitsSet(final int n) {
        int v = n;
        int c = 0;
        while(v != 0) {
            c++;
            v &= v - 1;
        }
        return c;
    }

    static String getBitMask(final int n) {
        StringBuffer bitMask = new StringBuffer();
        int mask = 1;
        while(mask != 0) {
            bitMask.insert(0, ((n & mask) != 0) ? "1": "0");
            mask  <<= 1;
        }

        return bitMask.toString();
    }

    static String getBitMask2(final int n) {
        StringBuffer bitMask = new StringBuffer();
        int count = 1;
        for(int i = 0; i < 32; i++) {
            bitMask.insert(0, ((n >> i & 1) > 0) ? "1": "0");
        }

        return bitMask.toString();
    }

    static public void main(String[] args) {
        System.out.printf("Bits mask of %d is %s\n", -2103453123, getBitMask2(-2103453123));
        System.out.printf("Bits mask of %d is %s\n", -2103453123, getBitMask(-2103453123));
        System.out.printf("Bits mask of %d is %s\n", 2103453123, getBitMask2(2103453123));
        System.out.printf("Bits mask of %d is %s\n", 2103453123, getBitMask(2103453123));
        System.out.printf("Bits mask of %d is %s\n", 123, getBitMask(123));
        System.out.printf("%d bits are set in %d\n", countBitsSet(123), 123);
        System.out.printf("Min of %d %d is %d\n", 10, 20, findMin(10, 20));
        System.out.printf("Min of %d %d is %d\n", 10, 20, findMax(10, 20));
        System.out.printf("%d is negative %b\n", -1, isNegative(-1));
        System.out.printf("%d is negative %b\n", 1, isNegative(1));
        System.out.printf("%d and %d have opposite %b\n", 1, -10, oppositeSigns(1, -10));
        System.out.printf("%d and %d have opposite %b\n", 1, -10, oppositeSigns(-1, -10));
    }
}
