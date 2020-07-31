package victor.training.java11;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TryWithResources {

   public static void main(String[] args) throws IOException {
//      System.out.close();;
      System.out.println("After");
      String s = """
        "f1"1, 
         """;

      checkLines(s.lines());

      checkLines(List.of("a","b").stream());
      checkLines(Stream.of("a","b"));

      Stream<String> lines = Files.lines(new File("data.txt").toPath());
//      lines = inputStream parsing (network)
//      line = read CLOB from DB
      checkLines(lines);

//      Writer writer = new FileWriter("data.txt");
//      try (writer) {
//         writer.write("AAA");
//      }
   }

   // use Collection<> everytime, unless the number of lines is too big to fit memory
   private static void checkLines(Stream<String> lines) {

      try (lines) {
         if (lines.filter(s -> debuggable(s)).count() <= 20) {
            throw new IllegalArgumentException("Incorrect file!");
         }
      }
//      lines.close(); -- automatically do this in a finally {
   }

   private List<String> filterLines(List<String> initial) {
      return initial.stream().filter(/*StringUtils::isNotBlank*/TryWithResources::debuggable).collect(toList());

   }

   private static boolean debuggable(String s) {
      return !s.isBlank();
   }
}
