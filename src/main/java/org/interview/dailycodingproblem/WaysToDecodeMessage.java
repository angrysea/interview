package org.interview.dailycodingproblem;

import java.util.*;

public class WaysToDecodeMessage {
    /*
    Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
    For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
    You can assume that the messages are decodable. For example, '001' is not allowed.
    */

    List<String> decodeMessager(String mapping) {
        List<String> results = new ArrayList<>();
        decoder(mapping, 0, "", results);
        return results;
    }

    List<String> decodeMessage(String mapping) {
        if(mapping == null || mapping.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        List<String> results = new ArrayList<>();
        Deque<String> values = new LinkedList<>();
        Deque<Integer> locations = new LinkedList<>();
        values.add("");
        locations.add(0);

        while(!values.isEmpty()) {
            String current = values.pop();
            int index = locations.pop();
            if(index < mapping.length()) {
                int n = mapping.charAt(index) - '0';
                values.push(current + (char)(n + 'a' - 1));
                locations.push(index + 1);
                if (index + 1 < mapping.length()) {
                    n *= 10;
                    n += mapping.charAt(index + 1) - '0';
                    if (n < 26) {
                        values.add(current + (char)(n + 'a' - 1));
                        locations.add(index + 2);
                    }
                }
            }
            else {
                results.add(current);
            }
        }
        return results;
    }

    void decoder(String mapping, int index, String current, List<String> results) {
        if(index == mapping.length()) {
            results.add(current);
            return;
        }

        int n = mapping.charAt(index) - '0';
        index++;
        decoder(mapping, index, current + (char)(n + 'a' - 1), results);

        if(index < mapping.length()) {
            n *= 10;
            n += mapping.charAt(index) - '0';
            if (n < 26) {
                decoder(mapping, index + 1, current + (char)(n + 'a' - 1), results);
            }
        }
    }

    static public void main(String[] args) {
        WaysToDecodeMessage o = new WaysToDecodeMessage();
        List<String> results = o.decodeMessage("121314");
        results.forEach(System.out::println);
    }
}
