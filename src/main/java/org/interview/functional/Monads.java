package org.interview.functional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Monads {

    Predicate<Integer> isEven = (number) -> number % 2 == 0;
    Function<Integer, Integer> doubleIt = (number) -> number * 3;

    private Optional<Integer> tryParse(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    interface Functor<T, F extends Functor<?,?>> {
        <R> F map(Function<T, R> f);
    }

    boolean isPrime(int number) {
        return number > 1 &&
                IntStream.range(2, number)
                .noneMatch(i -> number % i == 0);
    }
    static class Identity<T> implements Functor<T,Identity<?>> {
        private final T value;
        Identity(T value) { this.value = value; }
        public <R> Identity<R> map(Function<T,R> f) {
            final R result = f.apply(value);
            return new Identity<>(result);
        }
    }

    private Identity<Integer> print(Integer v) {
        System.out.println(v);
        return  new Identity<>(v);
    }

    Function<Integer, Predicate<Integer>> isGreaterThan = pivot -> number -> number > pivot;

    Function<List<Integer>, Function<Predicate<Integer>, Integer>> totalTheList =
            values -> test -> values.stream().filter(test).reduce(0, Math::addExact);

    private void test() {
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9, 10);

        System.out.println(totalTheList.apply(values).apply(isEven));

        Stream.of(1, 2, 3, 5, 6, 7, 8, 9, 10)
                .filter(isGreaterThan.apply(3))
                .filter(isEven)
                .map(doubleIt)
                .findFirst()
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        Monads monads = new Monads();

        IntStream.range(1, 8).forEach(i ->
                System.out.printf("isPrime(%d)? %b\n", i, monads.isPrime(i)));
        Supplier<Integer> aSupplier = () -> { return 5; };
        Consumer<Object> aConsumer = System.out::println;

        UnaryOperator<Integer> aOperator = (c) -> Integer.valueOf(c);
        BinaryOperator<Integer> aBinaryOperator = Integer::sum;
        var sum = aOperator.apply(5) + aBinaryOperator.apply(2, 2);

        aConsumer.accept(sum);

        System.out.println(aSupplier.get());
        aConsumer.accept(monads.isGreaterThan.apply(aSupplier.get()).test(sum));

        // Take an optional of a string call tryParse via flatmap which will unwrate the extra Optional
        //  that gets wrapped via the call see next line
        Optional.of("42").flatMap(monads::tryParse).ifPresent(System.out::println);
        Optional.of("42").map(monads::tryParse).ifPresent(o -> o.ifPresent(System.out::println));

        Identity<String> idString = new Identity<>("abc");
        Identity<Integer> idInt = idString.map(String::length);
        idInt.map(monads::print);

        Optional<Integer> param1 = Optional.of(5);
        Optional<Integer> param2 = Optional.of(25);
        Optional<Integer> results = param1.flatMap(first -> param2.flatMap(second -> Optional.of(first + second)));
        results.ifPresent(System.out::println);

        monads.test();
    }
}
