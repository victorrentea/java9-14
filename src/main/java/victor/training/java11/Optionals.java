package victor.training.java11;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class Optionals {
   public static void main(String[] args) {

       // Stackholm syndrome
      List<Optional<Integer>> opts = List.of(1,2,3,4,5).stream().map(Optional::of).collect(Collectors.toList());
      opts.stream().collect(Collectors.partitioningBy(Optional::isPresent)).get(true);
//      extractPresnt(opts).stream()
//          .filter(Optional::isPresent)
//          .map(Optional::get)
//          .collect(Collectors.toList());



      long t0 = System.currentTimeMillis();
      Optional<String> opt =  empty();

      // =flatMap+orElseGet
      String s = opt.or(() -> expensiveBackup()).orElse("nothing for backup either");

      System.out.println("Result = " + s);
      long t1 = System.currentTimeMillis();
      System.out.println(t1 - t0);
   }

   public static Optional<String> expensiveBackup() { // TODO what if this returns Optional<>
      System.out.println("Perform expensive operation to get a default");
      try {
         Thread.sleep(1000); // REST, File, DB
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.out.println("Done");
//      return Optional.of("backup");
      return empty();
   }
}
