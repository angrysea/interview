package org.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        if (num == 0) {
            result.add("0:00");
            return result;
        }
        char[] leds = new char[10];
        Arrays.fill(leds,'0');
        dfs(leds, 0, 0, num  - 1, result);

        List<String> output = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            String s = result.get(i);
            int hour = Integer.parseInt(s.substring(0,4),2);
            int minute = Integer.parseInt(s.substring(4),2);
            if (hour < 12 && minute < 60) {
                output.add(String.format("%d:%02d",hour, minute));
            }
        }
        return output;
    }

    void dfs(char[] leds, int idx, int current, int num, List<String> output) {
        if(idx >= leds.length) {
            return;
        }

        leds[idx] = '1';
        if (current == num) {
            output.add(String.valueOf(leds));
        }
        else if(current < leds.length) {
            dfs(leds, idx + 1,current + 1, num, output);
        }
        leds[idx] = '0';
        dfs(leds, idx + 1, current, num, output);
    }

    public static void main(String[] args) {
        BinaryWatch o = new BinaryWatch();
        o.readBinaryWatch(2).stream().forEach(System.out::println);
    }
}
