package victor.training.java11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import victor.training.stuff.CPUTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static victor.training.stuff.ConcurrencyUtil.*;

public class CompletableFutures implements Runnable {
   private static final Logger log = LoggerFactory.getLogger(CompletableFutures.class);

   public static void main(String[] args) throws InterruptedException {

      new Thread(new CompletableFutures()).start();

      ForkJoinPool exec2 = new ForkJoinPool(8);
      for (int i = 0; i < 10; i++) {
         CompletableFuture.supplyAsync(() -> getData())
             .thenApplyAsync(s -> {
                log.debug("Wait a bit, block everyone..");
                sleepQuiet(8000);
                log.debug("Resume...");
                return s;
             }).thenAccept(log::debug);

      }
      IntStream.range(1,40).parallel().peek(i -> {
         log.debug("Acum rulez " + i);
         sleepQuiet(100);
      }).forEach(System.out::println);

      Thread.sleep(6000);
   }

   private static String getData() {
      return "Good Stuff";
   }


   private static final CPUTask cpuTask = new CPUTask(1000);

   @Override
   public void run() {
      // another background task...
      log.debug("Started parallel task..");
      int delta = measureCall(this::anotherParallelTask);
      log.debug(" *** Parallel task took {} ms", delta);
   }
   public int anotherParallelTask() {
      return IntStream.range(1,30).parallel().peek(i -> cpuTask.run()).sum();
   }
}
