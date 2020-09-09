package victor.training.java11;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;

public class TryWithResources {
   public static void checkFile(Stream<String> lines) {
      try (lines) {
         if (lines.filter(s -> !s.isBlank()).count() <= 20) {
            throw new IllegalArgumentException("Incorrect file!");
         }
      }
   }

   public static void main(String[] args) throws IOException {
      Stream<String> lines = Files.lines(new File("data.txt").toPath());
      checkFile(lines); // fragile: if you NEED to be sure that resource is closed, then
   }
}
