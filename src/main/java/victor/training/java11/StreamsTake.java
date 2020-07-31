package victor.training.java11;

import java.util.List;
import java.util.stream.Stream;

public class StreamsTake {
   public static void main(String[] args) {
      List.of("","","Row1","Row2","Row3","","Row5").stream()
          .dropWhile(String::isEmpty)
//          .filter(s -> !s.isEmpty())
          .forEach(System.out::println);
      // dropWhile
   }
}
