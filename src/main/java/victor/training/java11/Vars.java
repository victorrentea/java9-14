package victor.training.java11;



import lombok.NonNull;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

   //class var {  } // asta nu mai merge din Java 10
   public static void main(String[] args) {
      var a = List.of("a", 1f, 2);

      Stream<BigDecimal> s =
//      var bigDecimalStream =
          IntStream.range(1, 100)
          .mapToObj(n -> "aa" + n)
          .map(BigDecimal::new);
//
//      v.filter
//      .map
//      .map;

//      var v = metodaStraina(); // LIst<Map<Inte,Str>>

//      try (var lines = Files.lines(new File("a.xtxt").toPath())) {
//         lines.forEach(System.out::println);
//      }


      var i = 1; // local variable type inference

      var var = 2; // merge pt ca var nu e keyword (ar fi rupt milioane de linii de cod vechi) ci este reserved type
//      int int = 2;

      var map = ofEntries(
          entry(1, List.of("one")),
          entry(2, List.of("two")),
          entry(3, List.of("three")),
          entry(4, List.of("three")),
          entry(5, List.of("three")),
          entry(6, List.of("three")),
          entry(7, List.of("three")),
          entry(8, List.of("three")),
          entry(9, List.of("three")),
          entry(10, List.of("three")),
          entry(11, List.of("three"))
      );


      for (var entry : map.entrySet()) {
         Integer key = entry.getKey();
      }
//      HttpResponse<ParameterizedType<List<MyDyo>>> response  = RestTemplate.exchange
//      var response  = RestTemplate.exchange
//      response.getBody().stream()
//      jackson.unmarshall (new ParameterizedReference<List<MyDto>>(){}.class, json);


      // "Target Typing": Incepand cu  java 8, lambda si meth reference pot fi definite
      // doar cand javac stie exact ce tip functional asteapta
      Function<Integer, Boolean> f = Vars::pred;
      Predicate<Integer> f2 = Vars::pred;

//      Function<?,?> f3 = Vars::pred; // KO javac
//      Object f = Vars::pred; // KO javac
      Object f3 = (Predicate<Integer>)Vars::pred; // KO javac
      var parse = (Function<Integer, Boolean>) Vars::pred; // KO javac
      I f5 = Vars::pred;
      I2 i2 = Vars::daSet; // covarianta in return type
      I3 i3 = Vars::iaColectie; // contravarianta in param

      Supplier<Set<Integer>> daSet = Vars::daSet;
      Supplier<Collection<Integer>> returnMaiGeneric = Vars::daSet;
      // toate <> se sterg mai putin din:
      // meth return type List<>
      // meth param type List<>
      // field List<String>
      // extends X<String>


      Predicate<String> ps = (@NonNull var ss) -> ss.toUpperCase().equals(ss);
   }
   interface I {
      boolean handle(Integer integer);
   }
   public static boolean pred(int n) {
       return n%2 ==0 ;
   }
   interface I2 {
      Collection<Integer> handle();
   }
   public static Set<Integer> daSet() {
      return Set.of(1, 2, 3);
   }
   interface I3 {
      void handle(Set<Integer> set);
   }
   public static void iaColectie(Collection<Integer> set) {

   }
}


//class A {
//   public Collection<String> s(List<Integer> i) {
//      return null;
//   }
//}
//class B  extends A{
//   @Override
//   public Set<String> s(Collection<Integer> any) {
//      return null;
//   }
//}
