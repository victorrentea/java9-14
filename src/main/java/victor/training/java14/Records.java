package victor.training.java14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Records {
   public static void main(String[] args) {
      // final final final
      // implements, abstract and extends
      // 2nd constructor
      // extra content
      // override generated methods
      System.out.println(new Interval<>(1, 4));
      Set<Interval<Integer>> objects = new TreeSet<>();
      objects.add(new Interval<>(2, 7));
      objects.add(new Interval<>(1, 3));
      System.out.println(objects);

      Circle circle = new Circle(2);
      System.out.println(circle.radius());
      Constructor<?> constructor = Circle.class.getConstructors()[0];
      for (Parameter parameter : constructor.getParameters()) {
         System.out.println(parameter.getName());
      }
      record MyTask(int i) implements Runnable {
         @Override
         public void run() {

         }
      };
//      new record Runnable() {
//
//      }

   }

   public static boolean intervalsIntersect(Interval interval1, Interval interval2) {
      return interval1.intersects(interval2);
   }
}

// [1,3]   <   [2,7]
record Interval<T extends Comparable<T>>(T start, T end) implements Comparable<Interval<T>> {
   public boolean intersects(Interval<T> other) {
      return start.compareTo(other.end) <= 0 &&
             other.start.compareTo(end) <= 0;
   }

   public Interval<T> withStart(T newStart) {

      return new Interval<T>(newStart, end);
   }

   @Override
   public int compareTo(Interval<T> o) {
      return start.compareTo(o.start);
   }
}

// X add more methods
// X more than 1 param
// YES change the generated methods ?
// YES comparable (implementing stuff)
// NO setters ? mutates by creating a new instance
// NO abstract records
   // abstract final class RecordBase {} // contradiction

// NO extends
   //class Shape {
   //   public int mutableShit;
   //}
   //record Circle(double radius) extends Shape {}

// OK generics
// OK inner classes -- possible, but don't
// NO adding extra fields vs the constructor
// anonymous records NO
// framework integration (mybatis, jackson HARD manually, Hibernate NO, JAXB NO)
// constructorS  - OK overloaded constructors



// constructor - logic in the constructor (eg validation)


// Vreti o discutie despre imutabilitate?

interface Shape {
   int CONSTANT_SHIT = 2;
   default double radius() {
      return 1;
   }
}
record Circle(double radius) implements Shape {
   public Circle {
      if (radius < 0) {
         throw new IllegalArgumentException();
      }
   }

   public Circle(String radiusStr) { // overloaded constructor needs to call another constructor.
      this(Double.parseDouble(radiusStr));
   }
   public Circle(String radiusStr, String second) { // overloaded constructor needs to call another constructor.
      this(radiusStr+second);
   }
}


class CircleClass {
   private final double radius;

   CircleClass(double radius) {
      if (radius < 0) {
         throw new IllegalArgumentException();
      }
      this.radius = radius;
   }
   CircleClass(String radius) {
      this.radius = Double.parseDouble(radius);
   }
}

record WebServiceConfig(List<EndpointConfig> endpoints) {
   static record EndpointConfig(String url, int timeout) {

   }
}

/*

JSON ---jackson--> Java
{
   endpoints: [
      {url:"...", timeout=10},
      {url:"...", timeout=20}
   ]
*/
