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
   public void checkFile(Supplier<Stream<String>> linesSupplier) {

      try (Stream<String> lines = linesSupplier.get()) {
         if (lines.filter(s -> !s.isBlank()).count() <= 20) {
            throw new IllegalArgumentException("Incorrect file!");
         }
      }

      try (Stream<String> lines = linesSupplier.get()) {
         if (lines.count() > 10000) {
            throw new IllegalArgumentException();
         }
//         while (true);
      }
   }

   public static void main(String[] args) throws IOException {
      TryWithResources res = new TryWithResources();

      res.checkFile(TryWithResources::f);
   }

   public static Stream<String> f() {
      try {
         return Files.lines(new File("a.txt").toPath());
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }
}
