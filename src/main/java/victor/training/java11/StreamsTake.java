package victor.training.java11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamsTake {
   public static void main(String[] args) {
      List<String> strings = List.of("", "", "Row1", "Row2", "Row3", "", "Row5");

      Object[] all = strings.stream().dropWhile(String::isBlank).toArray();
//      Object[] all = strings.stream().filter(s -> !s.isEmpty()).toArray();

      System.out.println(Arrays.toString(all));
      IntStream.of(1,3,5,7,8,9,10).takeWhile(n -> n%2 ==1).forEach(System.out::println);
   }
}
