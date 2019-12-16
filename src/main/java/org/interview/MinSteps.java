package org.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinSteps {
    Map<Integer, Integer> values = new HashMap<>();

    int solve(final int noStairs) {
        int noSteps = remainingSteps(noStairs, 0);

        return noSteps;
    }

    private int remainingSteps(int stairsLeft, int current) {

//
//
//
//        while(stairs > 0) {
//            steps.add(remaining);
//
//            Integer next = values.get(remaining);
//            if(next != null) {
//                remaining = next;
//            }
//            else if (remaining % 3 == 0) {
//                int newValue = remaining /= 3;
//                values
//            }
//            else if(remaining % 2 == 0) {
//                remaining /= 2;
//            }
//            else {
//                remaining--;
//            }
//        }
        return 0;
    }

    static public void main(String[] args) {
        MinSteps o = new MinSteps();
        System.out.printf("%d => ", o.solve(15));
    }
}
