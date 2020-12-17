package victor.training.java14;

public class Instanceof {
   public static void main(String[] args) {
      m("Hello");
      m(false);
   }
   public static void m(Object o) {
      if (o instanceof String s) {
         System.out.println("Someone said '" + s + "'");
      }

   }
}
