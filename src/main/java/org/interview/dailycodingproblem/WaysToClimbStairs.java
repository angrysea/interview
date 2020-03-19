package org.interview.dailycodingproblem;

import java.util.Arrays;

public class WaysToClimbStairs {
    int numWays(int[]counts, int noStairs) {
        if(noStairs == 0) {
            return 1;
        }

        //Arrays.sort(counts);
        int[] dp = new int[noStairs + 1];
        dp[0] = 1;
        for(int i = 1; i <= noStairs; i++) {
            int total = 0;
            for(int j : counts) {
                if(i - j >= 0) {
                    total += dp[i-j];
                }
                else {
                    break;
                }
                dp[i] = total;
            }
        }
        return dp[noStairs];
    }

    public static void main(String[] args) {
        WaysToClimbStairs o = new WaysToClimbStairs();
        System.out.printf("There are %d ways to climb the stairs.\n",
                o.numWays(new int[]{1, 2}, 4));
        System.out.printf("There are %d ways to climb the stairs.\n",
                o.numWays(new int[]{1, 3, 5}, 10));
        System.out.printf("There are %d ways to climb the stairs.\n",
                o.numWays(new int[]{1, 3, 5, 8}, 10));
    }
}
