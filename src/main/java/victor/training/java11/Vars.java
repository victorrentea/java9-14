package victor.training.java11;



import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Vars {

   // KO: lambdas, params, fields, var n;, = null, int[]
   // OK: "var var", var(), var.x.d
   // WTH!: var List.of, var <>, anonym subtype
   // avoid: long pipeline, less readable,
   // uses: long classname, generics, try-w-res,

   // var for lambda args, for annotations; all or none

   public static void main(String[] args) {
      Predicate<Apple> pred = (var apple) -> apple.isHeavy();
      var a = List.of(1, 2, 3, 4, "a", 1.0);
      var map = Map.of(1, List.of("one"), 2, List.of("two"));
      for (var entry : map.entrySet()) {
         System.out.println(entry.getKey());
      }


   }
}
class X {
   int x = 1;
   public void m() {

   }
}
class Apple {
   boolean isHeavy() {
      return true;
   }
}
