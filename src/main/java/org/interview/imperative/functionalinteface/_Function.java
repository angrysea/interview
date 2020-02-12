package org.interview.imperative.functionalinteface;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;

public class _Function {
    static Function<Integer, Integer> addOne = n -> n + 1;
    static Function<Integer, Integer> multiplyBy10 = n -> n * 10;
    static BiFunction<Integer, Integer, Integer> multiplyBy = (a, b) -> a * b;
    static ToDoubleBiFunction<Integer,Integer> divideBy = (a, b) -> Float.valueOf(a) / b;

    public static void main(String[] args) {
        Function<Integer, Integer> calc = addOne.andThen(multiplyBy10);
        System.out.println(calc.apply(1));
        System.out.println(multiplyBy.apply(2, 10));
        System.out.println(divideBy.applyAsDouble(11, 2));

    }
}
