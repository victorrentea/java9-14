package victor.training.java11;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PrivateDefault {

   public static void main(String[] args) {
      //
      List<String> list = new ArrayList<>();
      list.stream().forEach(System.out::println);

      ICommChanel smsChannel = new SmsChannel();
      smsChannel.sendAlert("Clientul o vrea");

      Mate mate = new Mate();
      System.out.println(mate.prod(1, 2));

//      smsChannel.logMessageSent("de ce o vad pe asta ?!");
   }
}

interface ICommChanel {
   void sendMessage(String message);

   default void sendAlert(String alert) {
      logMessageSent(alert);
      sendMessage(alert.toUpperCase() + "!");
   }
   default void sendNote(String alert) {
      logMessageSent(alert);
      sendMessage(alert.toLowerCase());
   }

   private void logMessageSent(String alert) {
      System.out.println("Internal method used by all implementations");
   }
}


// abstract class vs interfete cu met default
// FIELD + metode protected

class SmsChannel implements ICommChanel {
   @Override
   public void sendMessage(String message) {

   }
}

class EmailChannel implements ICommChanel {
   @Override
   public void sendMessage(String message) {

   }
}



// WRONG: contine logica si met def nu cheama vreo metoda abstracta din interface.
interface SumInterface {
   default int sum(int a, int b) {return a + b;}
}
interface ProductInterface {
   default int prod(int a, int b) {return a * b;}
}
// " e mai bine ca SumUtil/Helper"

class Mate implements SumInterface, ProductInterface {

}


// OK: Hook methods in interface:
interface WebMvcConfigurer {
   default void configurePathMatch(String configurer) {
   }
   default void configureContentNegotiation(String configurer) {
   }
}

// client = caller!
interface M{
   default void getMessage(String s) { // in loc de final eu as crea un wrapper class care prim o implem de interface {getMessage}
      getMessage(s, Locale.ENGLISH);
   }
   void getMessage(String s, Locale locale);
}
class MM implements M {
   @Override
   public void getMessage(String s, Locale locale) {

   }
}

class Wrapper {
   private final M m;

   Wrapper(M m) {
      this.m = m;
   }

   public void getMessage(String s) { // in loc de final eu as crea un wrapper class care prim o implem de interface {getMessage}
      getMessage(s, Locale.ENGLISH);
   }
   public void getMessage(String s, Locale locale) {
      m.getMessage(s, locale);
   }
}