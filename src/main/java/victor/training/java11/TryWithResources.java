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
      String s = """
        "f1"1, 
         """;

      checkFile(s.lines());


      Stream<String> lines = Files.lines(new File("data.txt").toPath());
//      lines = inputStream parsing (network)
//      line = read CLOB from DB
      checkFile(lines);
   }

   public static void checkFile(Stream<String> lines) {
      try (Stream<String> newStream = lines) {
         if (newStream.filter(s -> !s.isBlank()).count() <= 20) {
            throw new IllegalArgumentException("Incorrect file!");
         }
      }
//      lines.close(); -- automatically do this in a finally {
   }
}
