package victor.training.java11;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
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
      List<Person> people = Arrays.asList(new Person(1), new Person(2));
      Map<Long, Person> peopleById = people.stream().collect(toMap(Person::getId, identity()));
      // suggestive variable names can make the type obvious.
      for (var longPersonEntry : peopleById.entrySet()) { // shorter more focused code. use var to get rid of lots of <generics>
      }

      Function<Person, Long> idf = person -> person.getId(); // Target-typing
      Function<Person, Long> idfRef = Person::getId; // Target-typing
      Object idfObj = (Function<Person, Long>)(Person::getId);
//      var idf2 = (Person person) -> person.getId();



      // take people ACTIVE OR NotBanned
//      List<Predicate<Person>> all = List.of(Person::isActive, Person::isNotBanned);
//      List<Person> result = people.stream()
//          .filter(all.stream().reduce(p -> true, Predicate::or))
//          .collect(toList());

      Predicate<Person> isActive = Person::isActive;
      List<Person> result = people.stream()
          .filter(isActive.or(Person::isNotBanned))
          .collect(toList());


   }
}