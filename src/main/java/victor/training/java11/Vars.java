package victor.training.java11;



import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

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

   private static Map<Long, List<Integer>> getOrderAssociations() {
      return null;
   }

   public static void main(String[] args) throws IOException {

      for (var entry : map.entrySet()) {
         System.out.println(entry.getKey());
      }

      // let's image Java was JavaScript
      var i = 13; // Java COMPILER will figure out it has to be a integer there
      // (by looking at what you put in tha variable)

//      i = "1"; // NO!! Java is still statically type (Thank GOD!)

      // var j; // javac can't what't the variable type
      System.out.println("i is " + i);

      /*val >= ===*/
      final var arr = new int[]{0, 2, 3};
//      arr = new int[0];

//      var s = null; - null can be anything


      Predicate<Apple> lambda = Apple::isPoisonous;
      Function<Apple, Boolean> lambda2 = Apple::isPoisonous;

//      Object c = Apple::isPoisonous;
//      Object c2 = (Apple apple) -> apple.isPoisonous();

      // these don't work because Lambdas and Method references work by asking you to define their type
//      var cv = Apple::isPoisonous;
//      var cv2 = (Apple apple) -> apple.isPoisonous();

      Apple discordsApple = new Apple();
      lambda2.apply(discordsApple);

      Supplier<Boolean> lambda3 = discordsApple::isPoisonous;
      Boolean b = lambda3.get();


      var var = 1; // WORKS because var is java 10+ is NOT a keyword!! Instead it's a reserved Type name
      System.out.println(var);


      // ========================== BEST PRACTICES ===================
      // A) everywhere
      // B) never
      // C) here and there <==
      //      My answer: C, tending to B

      var map = getOrderAssociations(); // BAD because you would have to look
      // at the called method signature to figure out the type of that var (eg when you inspect a pull request)

      // Given you have clear names for methods and variables, ONLY then you might think of
      // giving up the type information for brevity

      Map<Long, List<Integer>> orderAssociations = getOrderAssociations();
      for (var entry : orderAssociations.entrySet()) { // in this case, what the entry holds is obvious from the code.

      }

//      long count = userRepo.count();
//      var count = userRepo.count(); // what did you really gain? 1 char? !

      try (var writer = new BufferedWriter(new FileWriter("file.txt"))) {
         writer.write("string");
      }


//      Stream<String> lines = databasequery
      try (var lines = Files.lines(new File("data.txt").toPath())) {
         lines.forEach(System.out::println);
      }

//      List<Object> weirdListType = List.of(1,"2",3.0);
      var weirdListType = List.of(1,"2",3.0);

   }

//   var vv = 1; // fields don't work with var

//   public static var m(var number) {} -- no var in method signatures
}

//class var { } // ILLEGAL from java 10+

class Apple {
   public boolean isPoisonous() {
      return true;
   }
}