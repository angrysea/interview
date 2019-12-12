package org.interview.functional;

import java.util.Optional;


public class FunWithOptionals {


    private static Optional<Integer> tryParse(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        ThrowingFunction<String, Integer> parse = (s) -> {
            return Integer.parseInt(s);
        };
        Runnable printError = () -> {
            System.out.println("Invalid numeric format!");
        };
        Optional<String> emptyString = Optional.empty();
        Optional<String> abcString = Optional.of("abc");

        var sFortyTwo = Optional.of("42");
        var nFortyTwo = sFortyTwo.flatMap(FunWithOptionals::tryParse);
        nFortyTwo.ifPresent(System.out::println);

        var nEmpty = abcString.flatMap(FunWithOptionals::tryParse);
        nEmpty.ifPresentOrElse(System.out::println, printError);

        var next = sFortyTwo.map(parse::apply);
        next.ifPresent(System.out::println);
        try {
            var empty = abcString.map(parse::apply);
            empty.ifPresent(System.out::println);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        var nEmpty2 = emptyString.flatMap(FunWithOptionals::tryParse);
        nEmpty2.ifPresent(System.out::println);

        ThrowingFunction<String, Integer> tryParse = Integer::parseInt;
        Integer i = tryParse.apply("42");
        try {
            Integer j = tryParse.apply("abc");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        Optional<Integer> param1 = Optional.of(5);
        Optional<Integer> param2 = Optional.of(25);
        Optional<Integer> results =
                param1.flatMap(first -> param2.flatMap(second -> Optional.of(first + second)));
        results.ifPresent(System.out::println);


    }
}
