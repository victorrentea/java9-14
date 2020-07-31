package victor.training.java11;

public class Person {
   private final long id;

   public Person(long id) {
      this.id = id;
   }


   public long getId() {
      return id;
   }
   public boolean isActive() {return true;}
   public boolean isNotBanned() {return true;}

}