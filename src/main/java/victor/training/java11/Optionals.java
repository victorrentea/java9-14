package victor.training.java11;


import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class Optionals {
   public static void main(String[] args) {
      System.out.println(getStreetNumber().flatMap(ss -> parseIfPossible(ss)));

      Optional<String> opt = Math.random() < 0.5 ? of("a") : empty();

//      opt.isEmpty();

//      String s = opt.orElseGet(() -> expensiveBackup()); // better -- calls it only if required
//      or === flatMap + orElseGet
      String s = opt.or(() -> expensiveBackup()).orElse(""); // better
//      String s = opt.orElse(expensiveBackup()); //take 1 second no matter what

      System.out.println("Result = " + s);

   }

   public static Optional<String> getStreetNumber() {
      return of("91");
   }

   public static Optional<Integer> parseIfPossible(String s) {
      if (s.matches("\\d+")) {
         return of(Integer.parseInt(s));
      } else {
         return empty();
      }
   }

//   public static void downloadBloodExamResults(Supplier<authorization> authorizer) {
//      if () {
//         authorizer.
//      }
//   }

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
