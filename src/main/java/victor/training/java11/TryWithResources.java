package victor.training.java11;

import java.io.InputStream;
import java.io.Reader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;

public class TryWithResources {
   public void checkFile(Stream<String> lines) {
      if (lines.filter(s -> !s.isBlank()).count() <= 20) {
         throw new IllegalArgumentException("Incorrect file!");
      }
   }
}
