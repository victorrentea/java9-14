package victor.training.java11;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class Vars {

   // use: local variab=, for index/variable
   // KO: lambdas, params, fields, var n;, = null, int[]
   // OK: "var var", var(), var.x.d
   // WTH!: var List.of, var <>, anonym subtype
   // avoid: long pipeline, less readable,
   // uses: long classname, generics, try-w-res,

   // var for lambda args, for annotations; all or none

   public static void main(String[] args) {
      var i = 2;
//      i = "a" not ok
      var s = "Hello var";
//      var i; // not ok

      List<Person> people = Arrays.asList(new Person(), new Person());
      Map<Long, Person> peopleById = people.stream().collect(toMap(Person::getId, identity()));

      for (var longPersonEntry : peopleById.entrySet()) { // shorter more focused code. use var to get rid of lots of <generics>

      }









   }
}