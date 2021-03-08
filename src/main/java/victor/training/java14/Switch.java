package victor.training.java14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

enum CountryCode {
   BG, MD, US, MX
//      ,
//      RO
}
public class Switch {
   private static final Logger log = LoggerFactory.getLogger(Switch.class);

   public static void main(String[] args) {
      System.out.println("VAT BG = " + getVAT(CountryCode.BG, 10, true));
      System.out.println("VAT BD = " + getVAT(CountryCode.MD, 20, false));

      auditMessage("CreateOrder");
   }

   private static double getVAT(CountryCode isoCode, double value, boolean tobacco) {
      /* TODO for MD return 5 + ... if tobacco==true */
      double v = switch (isoCode) {
         case BG -> 1;
         case US, MX -> 15 + .05 * value;
         case MD -> computeMoldavianTaxes(value, tobacco);
      };
      System.out.println("Inca ceva");
      return v;
   }

   private static double computeMoldavianTaxes(double value, boolean tobacco) {
      double result=7 + .02 * value;
      if (tobacco) {
         result += 5;
      }
      return result;
   }

//   private static Void hello(CountryCode isoCode) {
//      return switch (isoCode) {
//         case BG -> {
//            System.out.println("BG");
//            yield null;
//         }
//         case US, MX -> {System.out.println("Hola"); yield null;}
//         case MD -> {System.out.println("Privet!");yield null;}
//      };
//   }

   public static void auditMessage(String messageCode) {
//      switch (messageCode) {
//         case "CreateOrder":
//            log.info("Order Created");
//            break;
//
//         case "ViewOrder":
//         case "PrintOrder":
//            log.info("Order Accessed");
//            break;
//      }
      switch (messageCode) {
         case "CreateOrder" -> log.info("Order Created");
         case "ViewOrder", "PrintOrder" -> log.info("Order Accessed");
      }
   }
}

enum En {
   A,B,C
}
