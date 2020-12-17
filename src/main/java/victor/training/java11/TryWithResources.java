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
   public void checkFile(Stream<String> lines) {

//      try (lines) { // try with existing resource
         if (lines.filter(s -> !s.isBlank()).count() <= 20) {
            throw new IllegalArgumentException("Incorrect file!");
         }
//      }
   }

   public static void main(String[] args) throws IOException {
      TryWithResources res = new TryWithResources();

      try (Stream<String> lines = Files.lines(new File("a.txt").toPath())) {
         res.checkFile(lines);
      }
   }
}
