package org.interview.leetcode;

import java.util.Arrays;

public class BestTimeToBuyStock {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n == 0 || k == 0) {
            return 0;
        }
        int[][] transaction = new int[2][prices.length];
        for(int col = 0; col < prices.length; col++) {
            transaction[0][col] = 0;
        }

        int prev = 1, current = 0;

        // You can only trade a max of prices / 2 but one sell one. No need to go beyond that.
        for(int row = 0; row < Math.min(k, n/2); row++) {
            current = prev ^ current ^ (prev = current);
            int max = Integer.MIN_VALUE;
            for (int col = 1; col < n; col++) {
                if(col == 0) {
                    transaction[current][col] = 0;
                }
                else {
                    max = Math.max(max, transaction[prev][col - 1] - prices[col - 1]);
                    transaction[current][col] = Math.max(transaction[current][col - 1], prices[col] + max);
                }
            }
        }

        return transaction[current][n - 1];
    }

    static public void main(String[] args) {
        BestTimeToBuyStock o = new BestTimeToBuyStock();
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        int k = 4;
        System.out.println(o.maxProfit(k, prices));
        prices = new int[]{2,4,1};
        k = 2;
        System.out.println(o.maxProfit(k, prices));
    }
}
