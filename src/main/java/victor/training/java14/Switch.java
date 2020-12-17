package victor.training.java14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Switch {
   private static final Logger log = LoggerFactory.getLogger(Switch.class);
   public static void main(String[] args) {
      System.out.println("VAT BG = " + getVAT(Country.BG, 10, true));
      System.out.println("VAT BD = " + getVAT(Country.MD, 20, false));

      auditMessage("CreateOrder");
   }

   enum Country{
      BG, US, MX, MD,
      NL
   }

   private static double getVAT(Country isoCode, double value, boolean tobacco) {
      /* TODO for BG return 5 + ... if tobacco==true */
//      int x;
//      if (isoCode ==Country.BG) {
//         x = 2;
//      }
//      return x;
       return switch (isoCode) {
         case BG -> {
            if (tobacco) {
               yield 5 + 4;
            }
            yield 5;
         }
         case US, MX -> computeNonEuropeanTaxes(value);
         case MD -> computeMoldavianTaxes(value);
          case NL -> 2;
//         default -> throw new IllegalStateException("HOPE; Unexpected value: " + isoCode);
       };
   }

   private static double computeMoldavianTaxes(double value) {
      return 7 + .02 * value;
   }

   private static double computeNonEuropeanTaxes(double value) {
      // John had to put 3 lines of code somewhere, so why not here
      // John had to put 3 lines of code somewhere, so why not here
      // John had to put 3 lines of code somewhere, so why not here

      // Maria had to put 7 lines of code somewhere, so why not here
      // Maria had to put 7 lines of code somewhere, so why not here
      // Maria had to put 7 lines of code somewhere, so why not here
      // Maria had to put 7 lines of code somewhere, so why not here
      // Maria had to put 7 lines of code somewhere, so why not here
      // Maria had to put 7 lines of code somewhere, so why not here
      // Maria had to put 7 lines of code somewhere, so why not here

      return 15 + .05 * value;
   }

   public static void auditMessage(String messageCode) {
      switch (messageCode) {
         case "CreateOrder" ->
             log.info("Order Created");

         case "ViewOrder", "PrintOrder" ->
            log.info("Order Accessed");
      }
   }
}

enum En {
   A,B,C
}
