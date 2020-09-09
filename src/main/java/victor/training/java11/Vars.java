package victor.training.java11;



import java.util.*;
import java.util.Map.Entry;
import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static java.util.Map.entry;

public class Vars {

   // use: local variab=, for index/variable
   // KO: lambdas, params, fields, var n;, = null, int[]
   // OK: "var var", var(), var.x.d
   // WTH!: var List.of(string,float,int), var <>, anonym subtype
   // avoid: long pipeline, less readable,
   // uses: long classname, generics, try-w-res,

   // var for lambda args, for annotations; all or none

   public static final  Map<Integer,List<String>> map =
       Map.of(
       1, List.of("one","unu"),
       2, List.of("two"));

   public static void main(String[] args) {

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
