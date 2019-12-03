import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListStreamTest {
    public static void main(String[] args) {

        List<String> ms = Arrays.asList("2", "4", "5", "7", "1", "2", "3", "6");
        Map<String, String> map = Stream.of(new String[][] {
                { "1", "World" },
                { "2", "Hello" },
                { "3", "Doe" },
                { "4", "John" },
                { "5", "Bill" },
                { "6", "Smith" },
                { "7", "Jones" },
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        ms = ms.stream().map(map::get)
                .collect(Collectors.toList());

        ms.forEach(System.out::println);
    }
}
