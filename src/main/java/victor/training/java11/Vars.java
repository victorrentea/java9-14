package victor.training.java11;



import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;

public class Vars {

   // use: local variab=, for index/variable
   // KO: lambdas, params, fields, var n;, = null, int[]
   // OK: "var var", var(), var.x.d
   // WTH!: var List.of(string,float,int), var <>, anonym subtype
   // avoid: long pipeline, less readable,
   // uses: long classname, generics, try-w-res,

   // var for lambda args, for annotations; all or none

   public static void main(String[] args) {
      // TODO Map.of(), .ofEntries()
      Map<Integer, List<String>> map = new HashMap<>();
      map.put(1, Arrays.asList("one"));
      map.put(2, Arrays.asList("one", "two"));

      for (Entry<Integer, List<String>> entry : map.entrySet()) {
         System.out.println(entry.getKey());
      }
   }
}
