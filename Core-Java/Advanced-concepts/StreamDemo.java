import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {

        // create list
        List<Integer> list = Arrays.asList(10, 25, 30, 15, 40);

        // stream operations
        List<Integer> result = list.stream()
                .filter(x -> x > 20)     // filter values > 20
                .map(x -> x * 2)         // multiply by 2
                .sorted()                // sort
                .collect(Collectors.toList());  // collect to list

        // print result
        System.out.println("Result: " + result);
    }
}