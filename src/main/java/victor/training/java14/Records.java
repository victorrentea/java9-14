package victor.training.java14;

import lombok.Data;
import lombok.Value;

import java.util.List;

public class Records {
   public static void main(String[] args) {
      System.out.println(intervalsIntersect(new Interval(1, 3), new Interval(2, 4)));

//      List<Interval> list;
//      list.stream().map(Interval::getStart)

      // final final final
      // implements, abstract and extends
      // 2nd constructor
      // extra content
      // override generated methods
   }

   public static boolean intervalsIntersect(Interval interval1, Interval interval2) {
      return interval1.getStart() <= interval2.getEnd() && interval2.getStart() <= interval1.getEnd();
   }
}


//1:  @Data @Getter @Setter @ToString @Equals @AllArgsConstructor @RAC

//2: @Value @SneakyThrows

//3: val x= 1;     x=2;   ///  = var + final
//3: val x=new Struct();     x.setA(2);

@Value
class Interval {
   int start;
   int end;
}