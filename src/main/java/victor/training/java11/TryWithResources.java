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
   public static void main(String[] args) throws IOException {
      try (Stream<String> lines = Files.lines(new File("test.txt").toPath())) {
         checkFile(lines); // fragile: if you NEED to be sure that resource is closed, then
         checkFile2(lines);
      }
   }


   /// this function is in a far-away class

   public static void checkFile(Stream<String> lines) {
      if (lines.filter(s -> !s.isBlank()).count() >= 20) {
         throw new IllegalArgumentException("Incorrect file!");
      }
   }
   public static void checkFile2(Stream<String> lines) {
      if (lines.filter(s -> !s.isBlank()).count() > 2) {
         throw new IllegalArgumentException("Incorrect file!");
      }
   }
}
