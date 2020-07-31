package victor.training.java14;

import java.util.Objects;

// ~= @Data Lombok
record Interval(int start, int end) {
   public Interval {
      if (start > end) {
         throw new IllegalArgumentException();
      }
   }

   public Interval(String startStr, String endStr ) {
      this(Integer.parseInt(startStr), Integer.parseInt(endStr));
   }

   public boolean intersects(Interval other) {
      return start <= other.end && other.start <= end;
   }
}
//record Other extends Interval {}
// is similar to:

//public class Interval {
//   private final int start;
//   private final int end;
//
//   public Interval(int start, int end) {
//      this.start = start;
//      this.end = end;
//   }
//
//   public int start() {
//      return start;
//   }
//
//   public int end() {
//      return end;
//   }
//
//   @Override
//   public String toString() {
//      return "Interval{" +
//             "start=" + start +
//             ", end=" + end +
//             '}';
//   }
//
//   @Override
//   public boolean equals(Object o) {
//      if (this == o) return true;
//      if (o == null || getClass() != o.getClass()) return false;
//      Interval interval = (Interval) o;
//      return start == interval.start &&
//             end == interval.end;
//   }
//
//   @Override
//   public int hashCode() {
//      return Objects.hash(start, end);
//   }
//}
