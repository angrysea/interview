import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Monads {

    Predicate<Integer> isEven = (number) -> number % 2 == 0;
    Function<Integer, Integer> doubleIt = (number) -> number * 3;

    public Optional<Integer> optionalAdd(Optional<Integer> val1, Optional<Integer> val2) {
        return val1.flatMap(first -> val2.flatMap(second -> Optional.of(first + second)));
    }

    private Optional<Integer> tryParse(String s) {
        try {
            var i = Integer.parseInt(s);
            return Optional.of(i);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    interface Functor<T,F extends Functor<?,?>> {
        <R> F map(Function<T,R> f);
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

        var total = totalTheList.apply(values).apply(isEven);
        System.out.println(total);

        Stream.of(1, 2, 3, 5, 6, 7, 8, 9, 10)
                .filter(isGreaterThan.apply(3))
                .filter(isEven)
                .map(doubleIt)
                .findFirst()
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        Monads monads = new Monads();
        monads.test();

        Optional<String> str = Optional.of("42");
        Optional<Optional<Integer>> results1 = str.map(monads::tryParse);
        results1.ifPresent(o -> o.ifPresent(System.out::println));

        Identity<String> idString = new Identity<>("abc");
        Identity<Integer> idInt = idString.map(String::length);
        idInt.map(monads::print);

        Optional<Integer> param1 = Optional.of(5);
        Optional<Integer> param2 = Optional.of(25);

        Optional<Integer>  results = monads.optionalAdd(param1, param2);
        results.ifPresent(System.out::println);
    }
}
