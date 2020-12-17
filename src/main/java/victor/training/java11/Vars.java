package victor.training.java11;


import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;

public class Vars {

   // use: local variab=, for index/variable
   // KO: lambdas, params, fields, var n;, = null, int[]
   // OK: "var var", var(), var.x.d
   // WTH!: var List.of(string,float,int), var <>, anonym subtype
   // avoid: long pipeline, less readable,
   // uses: long classname, generics, try-w-res,

   // var for lambda args, for annotations; all or none

   public void var() {

   }

   public static final Map<Integer, List<String>> MAP = ofEntries(
       entry(1, List.of("one")),
       entry(2, List.of("one", "two")),
       entry(3, List.of("o", "t", "thr")),
       entry(3, List.of("o", "t", "thr")),
       entry(3, List.of("o", "t", "thr")),
       entry(3, List.of("o", "t", "thr")),
       entry(3, List.of("o", "t", "thr")),
       entry(3, List.of("o", "t", "thr")),
       entry(3, List.of("o", "t", "thr")),
       entry(3, List.of("o", "t", "thr")),
       entry(3, List.of("o", "t", "thr")),
       entry(3, List.of("o", "t", "thr")),
       entry(3, List.of("o", "t", "thr")),
       entry(3, List.of("o", "t", "thr"))
   );


   public static void main(String[] args) {
      // TODO Map.of(), .ofEntries()
//      Set.of(1, 2, 4);

      var x = 1;  // LOCAL VARIABLE (not params, not fiels) TYPE INFERENCE (not dynamic typing phew!!!)
//      x = 2;
      // var in JS
//      x = "a";


      var badName = theMethod();

      for (var entry : badName.entrySet()) {
         System.out.println(entry.getKey());
      }

//      StreamSupport.stream(badName.entrySet().spliterator(), false)
//      badName.entrySet().stream()
      //      File file = new File("a.txt");
//      try (Stream<List<String>> lineCells = openLineCellStream(file)) {
//         lineCells.forEach(Vars::handle);
//      }

//      RestTemplate ;
//
//      /*ResponseEntity<List<Whatever>>*/ var response = exchange("htt", new TypeReference<>)
//       response.getEntity().getBody()
   }

   private static void handle(List<String> strings) {

   }

   public static Map<Integer, List<String>> theMethod() {
      return MAP;
   }
//   var i = 1;
//   public void method(var i) {
//   }
}