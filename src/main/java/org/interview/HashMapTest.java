package org.interview;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        final String key = "The";
        String largestWord = null;
        int largest = 0;

        final String filename = "/Users/graffeoa/workspace/data/kingjames.txt";
        try (Scanner scanner = new Scanner(new File(filename))) {
            int value = 0;
            while (scanner.hasNext()) {
                String line = scanner.next();
                if (line.length() > largest) {
                    largest = line.length();
                    largestWord = line;
                }
                map.put(line, value++);
            }
            System.out.println("Number of words stored: " + value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Instant start = Instant.now();
        System.out.println("Key's: " + key + " value is " + map.get(key));
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Milli seconds to find: " + timeElapsed);

        System.out.println("Key's: " + largestWord + " value is " + map.get(largestWord));
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Milli seconds to find: " + timeElapsed);

        System.out.println("Key's: David value is " + map.get("David"));
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Milli seconds to find: " + timeElapsed);

        System.out.println("Key's: Lion value is " + map.get("Lion"));
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Milli seconds to find: " + timeElapsed);

        System.out.println("Key's: Lion value is " + map.get("heaven"));
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Milli seconds to find: " + timeElapsed);
    }
}
