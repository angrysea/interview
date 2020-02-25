package org.interview.leetcode;

public class ReverseBits {

    public int reverseTheBits(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, (n % 2) == 0 ? "0" : "1");
            n = n / 2;
        }
        for(int i = sb.length(); i < 31; i++) {
            sb.insert(0, '0');
        }
        char [] chars = sb.toString().toCharArray();
        int end = chars.length - 1;
        for(int i = 0; i < chars.length/2; i++) {
            char hold = chars[i];
            chars[i] = chars[end - i];
            chars[end - i] = hold;
        }
        int result = 0;
        for(int i=chars.length - 1; i>=0; i--) {
            if (chars[i] == '1')
                result += Math.pow(2, (chars.length - i - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits o = new ReverseBits();
        int r = 0;
        r = o.reverseTheBits(43261596);
        System.out.println(r);
        r = o.reverseTheBits(Integer.MAX_VALUE);
        System.out.println(r);
        r = o.reverseTheBits(Integer.MIN_VALUE);
        System.out.println(r);
    }
}