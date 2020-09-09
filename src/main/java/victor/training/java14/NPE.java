package victor.training.java14;


import java.util.Objects;


record A(B b) {

}
//class A {
//   private final B b;
//
//   public A(B b) {
//      this.b = b;
//   }
//
//   public B b() {
//      return b;
//   }
//
//   @Override
//   public String toString() {
//      return "A{" +
//             "b=" + b +
//             '}';
//   }
//
//   @Override
//   public boolean equals(Object o) {
//      if (this == o) return true;
//      if (o == null || getClass() != o.getClass()) return false;
//      A a = (A) o;
//      return Objects.equals(b, a.b);
//   }
//
//   @Override
//   public int hashCode() {
//      return Objects.hash(b);
//   }
//}


record B(C c) {
}

record C(String name) {
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
      System.out.println(a.b().c().name().toUpperCase());

      if (a !=null &&
//            a.b() != null &&
            a.b().c() != null) {
         System.out.println(a.b().c().name().toUpperCase());
      }
      //
//      System.out.println(a.getB().flatMap(b -> b.getC()).flatMap(c -> c.getName()).map(String::toUpperCase()).orElse());
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