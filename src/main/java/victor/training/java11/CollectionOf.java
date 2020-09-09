package victor.training.java11;


import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

public class CollectionOf {

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

   public static final  Map<Integer,List<String>> map = Map.ofEntries(
       entry(1, List.of("one","unu")),
       entry(2, List.of("two")),
       entry(2, List.of("two")),
       entry(2, List.of("two")),
       entry(2, List.of("two")),
       entry(2, List.of("two")),
       entry(2, List.of("two")),
       entry(2, List.of("two")),
       entry(2, List.of("two")),
       entry(2, List.of("two")),
       entry(2, List.of("two")),
       entry(2, List.of("two")),
       entry(2, List.of("two")),
       entry(2, List.of("two")),
       entry(2, List.of("two"))
//       ,2, List.of("two")// 11th illegal
   );

//   public static final Set<String> keys = new HashSet<>(asList("a","b","c"));
   public static final Set<String> keys = Set.of("a","b","c");

   public static void main(String[] args) {
//      map.put(3, asList("trei")); // throws: Map.of creates unmodifiable maps

      for (var entry : map.entrySet()) {
         System.out.println(entry.getKey());
      }

      // let's image Java was JavaScript
      var i = 13; // Java COMPILER will figure out it has to be a integer there
      // (by looking at what you put in tha variable)

//      i = "1"; // NO!! Java is still statically type (Thank GOD!)

      // var j; // javac can't what't the variable type
      System.out.println("i is " + i);
   }
}