package victor.training.java11;


import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class Optionals {
   public static void main(String[] args) {
      Optional<String> opt = Math.random() < 0.5 ? of("a") : empty();

//      String s = opt.orElseGet(() -> expensiveBackup());

      Optional<String> or = opt.or(() -> expensiveBackup());

      Optional<Integer> integer = opt.flatMap(s -> f(s));

//      System.out.println("Result = " + s);

//      Optional.of("12")
//          .flatMap(Optionals::parseAsInt)

   }


//   public static Optional<Integer> parseAsInt(String s) {
//      if (s.matches("\\d+")) {
//         return Optional.of(Integer.parseInt(s));
//      } else return empty();
//   }
//   public static Optional<Integer> parseAsFloat(String s) {
//      if (s.matches("\\d+\\.\\d+")) {
//         return Optional.of((int)Float.parseFloat(s));
//      } else return empty();
//   }
//

   private static Optional<Integer> f(String s) {
      return of(Integer.parseInt(s));
   }

   public static Optional<String> expensiveBackup() { // TODO what if this returns Optional<>
      System.out.println("Perform expensive operation to get a default");
      try {
         Thread.sleep(1000); // REST, File, DB
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.out.println("Done");
      return Optional.of("backup");
   }
}
