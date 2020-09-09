package victor.training.java14;

import java.util.Set;
import java.util.TreeSet;

public class Records {
   public static void main(String[] args) {
      // final final final
      // implements, abstract and extends
      // 2nd constructor
      // extra content
      // override generated methods
      System.out.println(new Interval(1, 4));
      Set<Interval> objects = new TreeSet<>();
      objects.add(new Interval(2, 7));
      objects.add(new Interval(1, 3));
      System.out.println(objects);
   }

   public static boolean intervalsIntersect(Interval interval1, Interval interval2) {
      return interval1.intersects(interval2);
   }
}
 // [1,3]   <   [2,7]
record Interval(int start, int end) implements Comparable<Interval> {
   public boolean intersects(Interval other) {
      return start <= other.end && other.start <= end;
   }
   public int endExclusive() {
      return end + 1;
   }

    @Override
    public int compareTo(Interval o) {
       return Integer.compare(start, o.start);
    }
 }

// X add more methods
// X more than 1 param
// YES change the generated methods ?


// extends // abstract records
// comparable (implementing stuff)
// setters ?
// inner classes
// anonymous records
// constructorS  - overloaded constructors + logic in the constructor (eg validation)
// framework integration (mybatis, jackson)


// Vreti o discutie despre imutabilitate?