package victor.training.java17;

public class Instanceof {
   public static void main(String[] args) {
      m("Hello");
      m(false);
   }
   public static void m(Object o) {
      if (o instanceof String) {
         String s = (String) o;
         System.out.println("Someone said '" + s + "'");
      }
   }
}
