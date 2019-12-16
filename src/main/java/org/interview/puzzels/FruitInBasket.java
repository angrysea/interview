package org.interview.puzzels;

import java.util.*;

public class FruitInBasket {
    public int totalFruit(int[] tree) {
        int ans = 0, i = 0, j = 0;
        int len = tree.length - 1;

        HashMap<Integer, Integer> map = new HashMap<>();
        while(j < tree.length) {
            if(map.size() <= 2) {
                map.put(tree[j], j++);
            }

            if(map.size() > 2) {
                int min = len;
                for (int value : map.values()) {
                    min = Math.min(min, value);
                }

                i = min + 1;
                map.remove(tree[min]);
            }
            ans = Math.max(ans, j - i);
        }

        return ans;
    }

    static public void main(String[] args) {
        FruitInBasket o = new FruitInBasket();
        System.out.printf("Fruits collected %d.\n",
                o.totalFruit(new int[]{1, 1, 1, 1, 2, 2, 3, 3, 3})); //6
        System.out.printf("Fruits collected %d.\n",
            o.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4})); //5
    }
}
