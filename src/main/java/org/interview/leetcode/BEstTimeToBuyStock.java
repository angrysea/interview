package org.interview.leetcode;
/*

       1  2  3  4  5  6  7
    2  5  7  1  4  3  1  3
 0  0  0  0  0  0  0  0  0
 1  0
 2  0
 3  0 
 */
public class BEstTimeToBuyStock {
    public int maxProfit(int k, int[] prices) {
        int[][] transaction = new int[k+1][prices.length+1];
        for(int row = 0; row < k + 1; row++) {
            transaction[row][0] = 0;
        }

        for(int col = 0; col < prices.length + 1; col++) {
            transaction[0][col] = 0;
        }

        for(int col = 1; col < prices.length + 1; col++) {
            for(int row = 1; row < k + 1; row++) {
                transaction[0][col] = 0;
            }
        }

        return 0;
    }

    static public void main(String[] args) {
        BEstTimeToBuyStock o = new BEstTimeToBuyStock();
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        o.maxProfit(k, prices);
    }
}
