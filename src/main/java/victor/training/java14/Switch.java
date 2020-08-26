package victor.training.java14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Switch {
   private static final Logger log = LoggerFactory.getLogger(Switch.class);
   public static void main(String[] args) {
      System.out.println("VAT BG = " + getVAT("BG", 10, true));
      System.out.println("VAT BD = " + getVAT("MD", 20, false));

      auditMessage("CreateOrder");
   }

   private static double getVAT(String isoCode, double value, boolean tobacco) {
      /* TODO for MD return 5 + ... if tobacco==true */
      switch (isoCode) {
         case "BG":
            return 0;
         case "US":
         case "MX":
            return 15 + .05 * value;
         case "MD":
            return 7 + .02 * value;
         default:
            throw new IllegalArgumentException();
      }
   }

   public static void auditMessage(String messageCode) {
      switch (messageCode) {
         case "CreateOrder":
            log.info("Order Created");
            break;

         case "ViewOrder":
         case "PrintOrder":
            log.info("Order Accessed");
            break;
      }
   }
}

enum En {
   A,B,C
}
