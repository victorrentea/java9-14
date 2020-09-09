package victor.training.java14;

public class Instanceof {
   public static void main(String[] args) {
      m("Hello");
      m(false);
   }
   public static void m(Object o) {
      // code smell :taking a generic object and deciding based on
      // instanceof what you have to do
      if (o instanceof String s) {
         System.out.println("Someone said '" + s + "'");
      }
      if (o instanceof Boolean b) {
         System.out.println("Got a " + (b?"YES":"NO"));
      }
   }
}
