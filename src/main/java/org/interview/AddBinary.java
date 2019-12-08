package org.interview;

import java.util.function.BiFunction;
import java.util.function.Function;

public class AddBinary {

    String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carryOver = 0;
        while(i >= 0 || j >= 0) {
            int sum = carryOver;
            if(i >= 0) {
                sum += a.charAt(i--) - '0';
            }

            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            sb.insert(0, sum % 2);
            carryOver = sum / 2;
        }

        if(carryOver > 0) {
            sb.insert(0, 1);;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();

        System.out.println(ab.addBinary("1010", "111"));
    }
}
