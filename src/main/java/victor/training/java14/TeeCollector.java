package victor.training.java14;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.summingInt;

public class TeeCollector {
   public static void main(String[] args) {
      int total = 0;
      // Java 12
      List<Integer> collect = IntStream.range(1, 10).boxed().collect(Collectors.toList());
      Long avg = collect.stream().peek(n -> {
//         total ++;
      }).collect(Collectors.teeing(summingInt(i -> i), counting(), (s, c) -> s / c));
      double asDouble = collect.stream().mapToInt(i -> i).average().getAsDouble();
//      collect.stream().reduce(0, (acc, e) -> acc + e);
      System.out.println(avg);

      Supplier<Integer> i = getIncrementer(2);
      System.out.println(i.get());
      System.out.println(i.get());
      System.out.println(i.get());
      System.out.println(i.get());
      System.out.println(i.get());
   }

   public static Supplier<Integer> getIncrementer(int a) {
       Point p = new Point(a + 1, 0);
//       Integer i = a + 1;
       return () -> p.x++; // lambda-ul creat are valoarea a+1 hardcodata.
   }


}
// tee linux : ii dai un input si copiaza pe stdout + file