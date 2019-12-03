package org.interview;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericTest {
    public static <T, G> List<G> fromArray(T[] values, Function<T, G> mapperFunction) {
        return Arrays.stream(values)
                .map(mapperFunction)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Integer[] values = {1, 2, 3, 4, 5};
        List<String> sValues = fromArray(values, Object::toString);
        sValues.forEach(System.out::println);
    }
}
