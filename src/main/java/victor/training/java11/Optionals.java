package victor.training.java11;


import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class Optionals {
   public static void main(String[] args) {
      Optional<String> opt = Math.random() < 0.5 ? of("a") : empty();

      String s = opt.orElseGet(() -> expensiveBackup());

      System.out.println("Result = " + s);
   }

   public static String expensiveBackup() { // TODO what if this returns Optional<>
      System.out.println("Perform expensive operation to get a default");
      try {
         Thread.sleep(1000); // REST, File, DB
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.out.println("Done");
      return "backup";
   }
}
