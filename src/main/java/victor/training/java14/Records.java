package victor.training.java14;

public class Records {
   public static void main(String[] args) {
      // final final final
      // implements, abstract and extends
      // 2nd constructor
      // extra content
      // override generated methods
   }

   public static boolean intervalsIntersect(Interval interval1, Interval interval2) {
//      return interval1.start() <= interval2.end() &&
//             interval2.start() <= interval1.end();
      return interval1.intersects(interval2);
   }
}

record Interval(int start, int end) {
   public boolean intersects(Interval other) {
      return start <= other.end && other.start <= end;
   }
}
// X add more methods


// extends // abstract records
// comparable (implementing stuff)
// framework integration (mybatis, jackson)
// change the generated methods ?
// setters ?
// more than 1 param
// inner classes
// anonymous records
// constructorS  - overloaded constructors + logic in the constructor (eg validation)


// Vreti o discutie despre imutabilitate?