package victor.training.java11;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;

public class TryWithResources {
   public static void main(String[] args) throws IOException {
      checkFile(TryWithResources::openFile); // fragile: if you NEED to be sure that resource is closed, then
      checkFile2(TryWithResources::openFile);

      // lines.reduce()// allow you to do many things at once in one single pass throught the stream
   }

   public static Stream<String> openFile() {
      try {
         return Files.lines(new File("test.txt").toPath());
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   /// this function is in a far-away class

   public static void checkFile(Supplier<Stream<String>> linesSupplier) {
      try (Stream<String> lines = linesSupplier.get()) {
         if (lines.filter(s -> !s.isBlank()).count() >= 20) {
            throw new IllegalArgumentException("Incorrect file!");
         }
      }
   }

   public static void checkFile2(Supplier<Stream<String>> linesSupplier) {
      try (Stream<String> lines = linesSupplier.get()) {
         if (lines.filter(s -> !s.isBlank()).count() > 2) {
            throw new IllegalArgumentException("Incorrect file!");
         }
      }
   }

   public static void checkFile3(Supplier<Stream<String>> linesSupplier) {

      Stream<String> lines = linesSupplier.get(); // risk 1: you forget to close it()
      if (lines.filter(s -> !s.isBlank()).count() > 2) {
         throw new IllegalArgumentException("Incorrect file!");
      }

   }
}
