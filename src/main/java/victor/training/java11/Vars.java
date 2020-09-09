package victor.training.java11;



import java.util.*;
import java.util.Map.Entry;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

public class Vars {

   // use: local variab=, for index/variable
   // KO: lambdas, params, fields, var n;, = null, int[]
   // OK: "var var", var(), var.x.d
   // WTH!: var List.of(string,float,int), var <>, anonym subtype
   // avoid: long pipeline, less readable,
   // uses: long classname, generics, try-w-res,

   // var for lambda args, for annotations; all or none


//   public static final  Map<Integer,List<String>> oldMap = new HashMap<>()
//   {//anonymous HashMap subclass
//      { // instance initializer block
//      put(1, asList("one"));
//      put(2, asList("two"));
//      }
//   };

   public static final  Map<Integer,List<String>> map = Map.of(
       1, Arrays.asList("one","unu"),
       2, List.of("two"),
       2, List.of("two"),
       2, List.of("two"),
       2, List.of("two"),
       2, List.of("two"),
       2, List.of("two"),
       2, List.of("two"),
       2, List.of("two"),
       2, List.of("two")
//       ,2, List.of("two")// 11th illegal
   );

//   public static final Set<String> keys = new HashSet<>(asList("a","b","c"));
   public static final Set<String> keys = Set.of("a","b","c");

   public static void main(String[] args) {

//      map.put(3, asList("trei")); // throws: Map.of creates unmodifiable maps


      for (Entry<Integer, List<String>> entry : map.entrySet()) {
         System.out.println(entry.getKey());
      }
   }
}
