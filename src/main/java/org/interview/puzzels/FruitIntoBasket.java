package org.interview.puzzels;

import java.util.LinkedList;
import java.util.List;

public class FruitIntoBasket {
    static private int[][] tests = {
            {1, 2, 1}, // 3
            {0, 1, 2, 2}, // 3
            {1, 2, 3, 2, 2}, // 4
            {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4} //5
    };

    int pickFruit(int[] grove) {
        int count = 0;
        List<Integer> blocks = new LinkedList<>();

        for (int i = 0; i < grove.length; i++) {
            if(i == 0 || grove[i] != grove[i - 1]) {
                blocks.add(i);
            }
        }


        return count;
    }

    int pickFruitBruteForce(int[] grove) {
        int count = 0;
        for(int i = 0; i < grove.length; i++) {
            int[][] baskets = new int[2][2];
            baskets[0][0] = baskets[1][0] = -1;
            for(int j = i; j < grove.length; j++) {
                if(baskets[0][0] == -1 || baskets[0][0] == grove[j]) {
                    baskets[0][0] = grove[j];
                    baskets[0][1]++;
                }
                else if(baskets[1][0] == -1 || baskets[1][0] == grove[j]) {
                    baskets[1][0] = grove[j];
                    baskets[1][1]++;
                }
                else {
                    break;
                }
            }
            count = Math.max(count, baskets[0][1] + baskets[1][1]);
        }
        return count;
    }

    static public void main(String[] args) {
        FruitIntoBasket o = new FruitIntoBasket();

        for(int i = 0; i < tests.length; i++) {
            System.out.println(tests[i] + ": " + o.pickFruit(tests[i]));
        }

    }
}
