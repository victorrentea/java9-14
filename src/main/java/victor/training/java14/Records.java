package victor.training.java14;

import java.util.Objects;

public class Records {
   public static void main(String[] args) {
      // final final final
      // implements, abstract and extends
      // 2nd constructor
      // extra content
      // override generated methods
   }

   public static boolean intervalsIntersect(Interval interval1, Interval interval2) {
      return interval1.getStart() <= interval2.getEnd() && interval2.getStart()<= interval1.getEnd();
   }
}
class Interval {
   private final int start;
   private final int end;

   Interval(int start, int end) {
      this.start = start;
      this.end = end;
   }

   public int getEnd() {
      return end;
   }

   public int getStart() {
      return start;
   }

   @Override
   public String toString() {
      return "Interval{" +
             "start=" + start +
             ", end=" + end +
             '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Interval interval = (Interval) o;
      return start == interval.start && end == interval.end;
   }

   @Override
   public int hashCode() {
      return Objects.hash(start, end);
   }
}