package org.interview.leetcode;

import java.util.Arrays;

public class CoinChange {
    
    int howManyCoins(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }

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
        int amount = 77;
        System.out.printf("It takes %d coins to total %d.\n",
                o.howManyCoins(new int[]{1,5,10,25}, amount), amount);
    }
}
