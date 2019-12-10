package org.interview.misc;

import org.apache.commons.lang3.tuple.Pair;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Streams {
    IntPredicate isEven = (number) -> number % 2 == 0;
    Pair<Integer, Integer> parts;
    private void testStreams() {
        int[] numbers = {4, 1, 13, 90, 16, 2, 0, 4, 1, 13, 2};
        IntStream.of(numbers)
                .filter(isEven)
                .distinct()
                .sorted()
                .limit(3)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        new Streams().testStreams();
    }

}
