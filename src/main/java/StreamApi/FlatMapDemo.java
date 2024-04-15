package StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapDemo {
    public static void main(String[] args) {
        List<Integer> even = Arrays.asList(2,4,6);
        List<Integer> odd = Arrays.asList(1,3,5);
        List<Integer> primes = Arrays.asList(2,3,5,7,11);

        List<Integer> list = (List<Integer>) Stream.of(even, odd, primes).flatMap(l->l.stream()).collect(Collectors.toList());
        System.out.println(list);


    }
}
