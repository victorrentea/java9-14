package victor.training.java14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Switch {
   private static final Logger log = LoggerFactory.getLogger(Switch.class);
   public static void main(String[] args) {
      processMessage("CreateOrder");

      System.out.println("VAT BG = " + getVAT(CountyIso.valueOf("BG"), true));
      System.out.println("VAT BD = " + getVAT(CountyIso.valueOf("MD"), false));
   }

   private static int getVAT(CountyIso isoCode, boolean tobacco) {
       return switch (isoCode) {
         case BG -> 0;
         case US, MX -> 15;
         case MD -> 5;
//         default -> throw new IllegalArgumentException("JDD: hope to catch a missing enum");
      };
   }
   enum CountyIso {
      BG,US,MX,MD
//      , NEW_VAL
   }

   public static void processMessage(String messageCode) {
      switch (messageCode) {
         case "CreateOrder" -> log.info("Order Created");
         case "ViewOrder", "ExportOrder", "PrintOrder" -> log.info("Order Accessed");
      }
   }
}

enum En {
   A,B,C
}
