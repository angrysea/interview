package org.interview.leetcode;

import java.util.Arrays;

public class CoinChange {


    int howManyCoins(int[] coins, int amount) {
        int count = 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        Arrays.sort(coins);

        for(int i = 0; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
                else {
                    break;
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange o = new CoinChange();
        System.out.printf("It takes %d coins to total 11",
                o.howManyCoins(new int[]{1,2,5}, 11));
    }
}
