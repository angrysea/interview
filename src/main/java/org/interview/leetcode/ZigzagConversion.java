package org.interview.leetcode;

public class ZigzagConversion {
   public String convert(String s, int numRows) {
        if(s==null) {
            return null;
        }

        int last = s.length() - 1;
        if(last < numRows) {
            return s;
        }
        int cycle = Math.max(1, (numRows * 2) - 2);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < numRows; i++) {
            boolean firstOrLast = i == 0 || i == numRows - 1;
            for(int j = 0; j + i <= last; j += cycle) {
                sb.append(s.charAt(i + j));
                if (!firstOrLast) {
                    int k = (j + cycle) - i;
                    if (k <= last) {
                        sb.append(s.charAt(k));
                    }
                }
            }
        }
        return sb.toString();
    }

    /*
     * 3 rows PAHNAPLSIIGYIR
     * 4 rows PINALSIGYAHRPI
     */
    static public void main(String[] args) {
        ZigzagConversion o = new ZigzagConversion();
        System.out.println(o.convert("A", 1));
        System.out.println(o.convert("AB", 1));
        System.out.println(o.convert("PAYPALISHIRING", 3));
        System.out.println(o.convert("PAYPALISHIRING", 4));
    }
}
