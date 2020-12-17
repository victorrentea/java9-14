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




      // What should I do with records in production?
      // 1) record + Hibernate = NO
      // 2) record + noSQL

      // 3) use them for Hibernate : Projection Queries
      // SELECT new victor.training.java14.Interval(car.startYear, car.endYear)
      // FROM CarEntity car .... //

      // 4) runtime data objects (stuff that you write your logic on)
      // plays nice with Functional style programming (pure functions)
      // it's a DECLARATIVE plaing sight statement: I wont' change the state of my objects.

      // !! less boilerplate
      // replacing lombok.@Value everywhere


      // 5) NOT for Jackson yet. It will be there.
      // you will need to use annotations. they appear to support it already https://github.com/FasterXML/jackson-future-ideas/issues/46

      // Immutable object are painful (cumbersome and maybe GC unfriendly) to work with :eg> interval.moveRight

      // it doesn't pay off to use records at the DTO level.


      System.out.println(new Interval(1,3).equals(new Interval(1,3)));
      Interval intv = new Interval(1, 3);
      System.out.println(intv);
      intv = intv.moveLeft(1);


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



