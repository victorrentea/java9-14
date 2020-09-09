package victor.training.java14;


class A {
 private final B b;

   A(B b) {
      this.b = b;
   }

   public B getB() {
      return b;
   }
}
class B {
   private final C c;

   B(C c) {
      this.c = c;
   }

   public C getC() {
      return c;
   }
}
class C {
   private final String name;

   C(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }
}

// -XX:+ShowCodeDetailsInExceptionMessages - enable this in PROD but take care not to slip exceptions
// to the user
 //@RestControllerAdvice or try { stuff} catch(Exception ex) {ex.log...}

public class NPE {
   public static void main(String[] args) {
         output(new A(new B(new C("Halo"))));
//         output(new A(new B(new C(null))));
         output(new A(new B(null)));
//         output(new A(null));

      //but it still doesn't solve 'returning death nulls'
//      System.out.println(nastyBizFunction(5123).repeat(2));
      //
   }


   private static void output(A a) {
      System.out.println(a.getB().getC().getName().toUpperCase());
   }

   private static String nastyBizFunction(int x) {
      if (x % 3 == 1) {
         return nasty2(x + 1);
      } else {
         return nasty3(x % 3 - 1);
      }
   }

   private static String nasty2(int x) {
      return x + "";
   }

   private static String nasty3(int x) {
      if (x < 0) {
         return x + "";
      }
      return null;
   }
}