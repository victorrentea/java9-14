package victor.training.java14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Switch {
   private static final Logger log = LoggerFactory.getLogger(Switch.class);
   public static void main(String[] args) {
      processMessage("CreateOrder");
      
      System.out.println("VAT BG = " + getVAT("BG"));
      System.out.println("VAT BD = " + getVAT("MD"));
   }

   private static int getVAT(String isoCode) {
      switch (isoCode) {
         case "BG": return 0;
         case "US","MX": return 15;
         case "MD": return 5;
         default: throw new IllegalArgumentException();
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
