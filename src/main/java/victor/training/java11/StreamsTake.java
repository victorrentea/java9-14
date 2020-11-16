package victor.training.java11;

import java.util.List;
import java.util.stream.Stream;

public class StreamsTake {
   public static void main(String[] args) {
      List<String> strings = List.of("", "", "Row1", "Row2", "Row3", "", "Row5");

      long firstBlankLinesCount = strings.stream().takeWhile(String::isBlank).count();
      System.out.println(firstBlankLinesCount);

      strings.stream().dropWhile(String::isBlank).forEach(System.out::println);
      // dropWhile
   }
}
