package victor.training.java14;


import lombok.Data;
import lombok.Value;

@Value
public class Interval {
   int start;
   int end;


   public boolean intersects(Interval other) {
      return start <= other.end && other.start <= end;
   }
}
