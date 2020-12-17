package victor.training.java14;


//@Builder
public record Interval(int start, int end) {
//   int x; // mutable

   public Interval { // where the hack is the argument list?
      // the default constructor is partially generated:
      // this.start=start happens in the bytecode AFTER you do the if.
      if (start > end) {
         throw new IllegalArgumentException();
      }
   }

   public Interval(String startStr, String endStr) {
      this(Integer.parseInt(startStr), Integer.parseInt(endStr));
   }

   public boolean intersects(Interval other) {
      return start <= other.end && other.start <= end;
   }

   public Interval moveLeft(int delta) {
      return new Interval(start - delta, end - delta);
   }

   public static class IntervalBuilder {
      private int start, end;

      public IntervalBuilder withStart(int start) {
         this.start = start;
         return this;
      }
      public IntervalBuilder withEnd(int end) {
         this.end = end;
         return this;
      }
      public Interval build() {
         return new Interval(start,end);
      }
   }
}
