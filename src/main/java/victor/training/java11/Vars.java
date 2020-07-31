package victor.training.java11;


import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Vars { // local-variable type inferance
//   private var x = 1; // KO

//    use: local variab=, for index/variable
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

      List<Person> result2 = people.stream()
          .filter(p -> p.isNotBanned() || p.isActive())
          .collect(toList());


      // UC353
      List<Person> result3 = people.stream()
          .filter(Vars::deservesPromotion)
          .collect(toList());


      List<Person> result4 = new ArrayList<>();
      for (Person person : people) {
         if (person.isActive() || person.isNotBanned()) {
            result4.add(person);
         }
      }

      noVarsInitToNull();
   }

   private static boolean deservesPromotion(Person p) {
      return p.isNotBanned() || p.isActive();
   }

   private static void noVarsInitToNull() {
      boolean b = true;
//      var userToNotify = null; // NO
      Optional<Person> userToNotify = getPersonToNotify(b);

      if (userToNotify.isPresent()) {
         System.out.println("send email to " + userToNotify);
      }
   }

   private static Optional<Person> getPersonToNotify(boolean b) {
      if (b) {
         return of(otherFunc()); // fail fast if otherFunc returns null
      } else {
         return empty();
      }
   }

   private static Person otherFunc() {
      return new Person(1);
   }
}