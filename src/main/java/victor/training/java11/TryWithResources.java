package victor.training.java11;

import java.io.*;
import java.nio.file.Files;
import java.util.stream.Stream;

public class TryWithResources {

   public static void main(String[] args) throws IOException {
      String s = """
        "f1"1, 
         """;

      checkLines(s.lines());


      Stream<String> lines = Files.lines(new File("data.txt").toPath());
//      lines = inputStream parsing (network)
//      line = read CLOB from DB
      checkLines(lines);

//      Writer writer = new FileWriter("data.txt");
//      try (writer) {
//         writer.write("AAA");
//      }
   }

   public static void checkLines(Stream<String> lines) {
      try (lines) {
         if (lines.filter(s -> !s.isBlank()).count() <= 20) {
            throw new IllegalArgumentException("Incorrect file!");
         }
      }
//      lines.close(); -- automatically do this in a finally {
   }
}
