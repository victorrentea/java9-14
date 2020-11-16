package victor.training.java14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Switch {
   private static final Logger log = LoggerFactory.getLogger(Switch.class);
   public static void main(String[] args) {
      System.out.println("VAT BG = " + getVAT("BG", 10, true));
      System.out.println("VAT BD = " + getVAT("MD", 20, false));

      auditMessage(MessageCode.CreateOrder);
   }

   private static double getVAT(String isoCode, double value, boolean tobacco) {
      // asta este statement nu intoarce nimic. De aia ii zicem enhanced switch
      switch (isoCode) {
         case "BG" -> System.out.println("Balgaria");
         case "US", "MX" -> System.out.println("Side effects");
         case "MD" -> System.out.println("Moldavia");
         default -> throw new IllegalArgumentException();
      };

      //cel mai cool este insa sa-l folosesti ca expresie sa dai return switch.
      // daca faci asta ---> si swithcezi pe enum--===> paradisul. verifica javac ca ai acoperit toate bransele si default devine inutil.
      /* TODO for MD return 5 + ... if tobacco==true */
      return switch (isoCode) {
         case "BG" -> 0;
         case "US", "MX" -> 15 + .05 * value;
         case "MD" -> computeMoldova(value, tobacco);
         default -> throw new IllegalArgumentException();
      };
   }

   private static double computeMoldova(double value, boolean tobacco) {
      var result = 7 + .02 * value;
      if (tobacco) {
         result += 5;
      }
      return result;
   }

   public static int auditMessage(MessageCode messageCode) {
      //daca folosesti valoarea intoarsa de un swithc EXPRESSION -> si switchezi pe un enum,
      // javac poate sa valideze ca acoperi toate bransele:
      // ===> nu mai ai nevoi de default:throw ci nu va mai compila
      return switch (messageCode) {
         case CreateOrder -> {
            if (true) yield 2;
            log.info("Order Created");
            yield 1;
         }
         case ViewOrder, PrintOrder -> 2;
         case Maine -> 2;
//         default -> 2;
      };
   }
}


enum MessageCode {
   CreateOrder,
   ViewOrder,
   PrintOrder,
   Maine
}

enum En {
   A,B,C
}
