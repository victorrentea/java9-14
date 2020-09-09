package victor.training.java14;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.summingInt;

public class TeeCollector {
   public static void main(String[] args) {
      // Java 12
      List<Integer> collect = IntStream.range(1, 10).boxed().collect(Collectors.toList());
      Long avg = collect.stream().collect(Collectors.teeing(summingInt(i -> i), counting(), (s, c) -> s / c));
//      Long avg = collect.stream().mapToInt(i -> i).average();
      System.out.println(avg);
   }
}
