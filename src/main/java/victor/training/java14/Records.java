package victor.training.java14;

import static java.lang.Integer.parseInt;

public class Records {
   public static void main(String[] args) {

      System.out.println(new Interval(1, 1).equals(new Interval(1, 1)));

      Interval interval = new Interval(1, 2);

      interval = interval.moveRight(1);

      Interval overLoad = new Interval("1", "0");


//      Interval nuEOk = new Interval(1, 0); // exceptie

      // final final final
      // implements, abstract and extends
      // 2nd constructor
      // extra content
      // override generated methods


      //Profetie: In java 23 vei putea face asa:

      // ca in JS,   TS , py, Scala, Kotlin
//      Interval(int x, int y) = overload;
   }
}


record Interval(int start, int end) implements Comparable<Interval>{
   // hibernate nu va suporta vreodata asa ceva entityManager.getReference();
   // Jackson face eforturi - va merge
   // JAXB nu cred ca va merge prea curand (WSDL, XSD)
   // Mongo va suporta asa cum suporta deja Immutables (librarie)

   public Interval {
      if (start > end) throw new IllegalArgumentException();
   }

   public Interval(String startStr, String endStr) {
      this(parseInt(startStr), parseInt(endStr));
   }

   public int endExclusive() {
      return end + 1;
   }

   public boolean intersects(Interval other) {
      return start <= other.end && other.start<= end;
   }

   public Interval moveRight(int delta) {
      return new Interval(start + delta, end + delta);
   }

   public float center() {
      return (start + end) / 2.0f;
   }

   @Override
   public int compareTo(Interval o) {
      return Float.compare(center(), o.center());
   }
}

