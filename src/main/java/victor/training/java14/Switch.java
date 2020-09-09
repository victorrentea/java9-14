package victor.training.java14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class Switch {
   private static final Logger log = LoggerFactory.getLogger(Switch.class);

   public static void main(String[] args) throws IOException {
      System.out.println("VAT BG = " + getVAT("BG", 10, true));
      System.out.println("VAT BD = " + getVAT("MD", 20, false));
      System.out.println("VAT BD = " + getVAT("UK", 20, false));

      auditMessage("CreateOrder");
   }

   private static double getVAT(String countryIsoCode, double value, boolean tobacco) throws IOException {
      /* TODO for MD return 5 + ... if tobacco==true */

//      switch (countryIsoCode) {
//         case "BG":
//            return 0;
//         case "US":
//         case "MX":
//            return 15 + .05 * value;
//         case "MD":
//            return 7 + .02 * value;
//         default:
//            throw new IllegalStateException("Unexpected value: " + countryIsoCode);
//      }
      return switch (countryIsoCode) {
         case "BG" -> 0;
         case "US", "MX" -> {
            if (tobacco) {
               yield 10 + 15 + .05 * value;
            } else {
               yield 15 + .05 * value;
            }
         }
         case "MD" -> 7 + .02 * value;
         default -> throw new IllegalStateException("Unexpected value: " + countryIsoCode);
      };
   }


//   public void m(boolean b) {
//      int lv;
//      if (b) {
//         lv = 1;
//      }
//      return lv;
//   }


   public static void auditMessage(String messageCode) {
      switch (messageCode) {
         case "CreateOrder" -> auditCreateOrder();
         case "ViewOrder", "PrintOrder" -> log.info("Order Accessed");
      }
   }

   public static void auditCreateOrder() {
      log.info("Order Created");
      log.info("Order Created END");
   }
}

enum En {
   A, B, C
}
