package victor.training.java14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Switch {
   private static final Logger log = LoggerFactory.getLogger(Switch.class);
   public static void main(String[] args) {
      processMessage("CreateOrder");

      System.out.println("VAT BG = " + getVAT("BG", true));
      System.out.println("VAT BD = " + getVAT("MD", false));
   }

   private static int getVAT(String isoCode, boolean tobacco) {
      switch (isoCode) {
         case "BG":
            return 0;
         case "US":
         case "MX":
            return 15;
         case "MD":
            if (tobacco) {
               return 7;
            } else {
               return 5;
            }
         default:
            throw new IllegalArgumentException();
      }
   }

   public static void processMessage(String messageCode) {
      switch (messageCode) {
         case "CreateOrder":
            log.info("Order Created");
            break;

         case "ViewOrder":
         case "ExportOrder":
         case "PrintOrder":
            log.info("Order Accessed");
            break;
      }
   }
}

enum En {
   A,B,C
}
