package victor.training.java14;

public class Records {
   public static void main(String[] args) {
      Interval interval1 = new Interval(1, 3);
//      new Interval(3, 1);
      new Interval("1-3");
      System.out.println(interval1.intersects(new Interval(2, 4)));

      System.out.println(interval1.compareTo(new Interval(2,7)));
      System.out.println(new Interval(1, 3).length());
      // final final final
      // implements, abstract and extends
      // 2nd constructor
      // extra content
      // override generated methods
   }

}


record Interval(int start, int end) implements Comparable<Interval> {

   public Interval {
      System.out.println("WHAT?! constructor fara paranteze, O abominatie !");
      // pentru ca campurile deja au fost copiat
      if (start > end) {
         throw new IllegalArgumentException();
      }
   }

   public Interval(String startStr, String endStr) {
      this(Integer.parseInt(startStr), Integer.parseInt(endStr));
   }
   public Interval(String intervalStr) {
      this(met(intervalStr)[0], met(intervalStr)[1]);
   }

   public static String[] met(String intervalStr) {
      return intervalStr.split("-");
   }

   public boolean intersects(Interval interval2) {
      return start <= interval2.end && interval2.start <= end;
   }

   public int length() {
      return end - start;
   }

   @Override
   public int end() {
      return end;
   }

   @Override
   public int compareTo(Interval o) {
      return length() - o.length();
   }


   @Override
   public String toString() {
      return "[" + start + ", " + end + ']';
   }
}


//@Value
//class Interval {
//   int start;
//   int end;
//}