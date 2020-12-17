package victor.training.java14;

public class Records {
   public static void main(String[] args) {
      // final final final
      // 2nd constructor
      // extra content
      // override generated methods

      // TODO implements, abstract and extends
      // sealed classes




//      new Interval(4, 3); // should throw exception
      new Interval("2", "3");






      System.out.println(new Interval(1,3).equals(new Interval(1,3)));
      Interval intv = new Interval(1, 3);
      System.out.println(intv);
      intv.moveLeft(1);


      System.out.println(new Interval(1, 3).intersects(new Interval(2, 4)));
      System.out.println(new Interval(10, 30).intersects(new Interval(20, 40)));
   }

}

// buidlers for mutable object wrapped inside "under construction"
//class IntervalBuilder {
//   private final Interval in = new Interval();
//
//   public IntervalBuilder withStart(int start) {
//      in.setStart(start);
//      return this;
//   }
//}

// Immutable Builer pattern



