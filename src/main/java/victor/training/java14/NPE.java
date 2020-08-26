package victor.training.java14;

// -XX:+ShowCodeDetailsInExceptionMessages
public class NPE {
   public static void main(String[] args) {
      output(new A(new B(new C("Halo"))));

      //but it still doesn't solve 'returning death nulls'
      System.out.println(nastyBizFunction(5123).repeat(2));
   }


   private static void output(A a) {
      System.out.println(a.b().c().s().toUpperCase());
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

record A(B b) {}
record B(C c) {}
record C(String s) {}