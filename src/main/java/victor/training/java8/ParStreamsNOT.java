package victor.training.java8;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Slf4j
public class ParStreamsNOT {
   public static void main(String[] args) throws ExecutionException, InterruptedException {
      List<Integer> list = IntStream.range(1,10_000).boxed().collect(toList());

      Stream<Integer> str = list.parallelStream()
          .map(n -> {
             log.info("Square " + n);

             // Stuff that takes time in PRODUCTION

             // TinyCPU: NO, millions of little tiny ops (hashCode) -- > the overhead of parallelizing exceeds the gain of doing the tiny work in parallel
             // Heavy CPU: you don't normally have these. [un]marhsalling XML, hashshing SHA-512 (mining bitcoin), encryption asymm (valdating tokens), PDF/XLS generation
             // IO: NO!!! database interaction, API calls (SOAP, REST, RMI, ), Files <<< YOUR PROBLEM
             return n * n;
          });

      ForkJoinPool pool = new ForkJoinPool(2);
      List<Integer> squares =  pool.submit(    () -> str.collect(toList())     ).get();

      // insead of that, why not Spr Batch
      System.out.println(squares);
   }
}
