package victor.training.java11;

public class Person {
   private long id;
   private String name;

   public Person(long id) {
      this.id = id;
   }

   public Person(String name) {
      this.name = name;
   }

   public long getId() {
      return id;
   }
   public boolean isActive() {return true;}
   public boolean isNotBanned() {return true;}

}
