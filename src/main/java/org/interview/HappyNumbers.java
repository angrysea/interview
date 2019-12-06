package org.interview;

import java.util.HashSet;
import java.util.Set;

public class HappyNumbers {

    boolean isHappy(int n){
        Set<Integer> foundNumbers = new HashSet<>();
        int num = n;
        while(num != 1) {
            int current = num, sum = 0;
            while(current != 0) {
                int mod10 = current % 10;
                sum += Math.pow(mod10, 2);
                current /= 10;
            }

            if(foundNumbers.contains(sum)) {
                return false;
            }
            foundNumbers.add(sum);
            num = sum;
        }

        System.out.println("Is a unHappy number: " + n + " result: " + num);
        return true;
    }

    public static void main(String[] args) {
        new HappyNumbers().isHappy(19);
    }
}
