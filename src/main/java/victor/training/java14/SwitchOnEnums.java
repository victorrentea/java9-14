package victor.training.java14;

public class SwitchOnEnums {

   public double m(FiscalZone zone, double baseAmount) {
      return switch (zone) {
         case CH, EU -> 0;
         case UK -> baseAmount * .01;
         case WORLD -> baseAmount * .1;
         case US -> 0.0;
      };
   }
   public void handle(FiscalZone zone) {
      Void v = switch (zone) {
         case CH, EU -> handleEU();
         case UK -> handleUK();
         case WORLD -> handleWorld();
         case US -> null;
      };
   }

   public Void handleEU() {
      System.out.println("Free zone");
      return null;
   }

   public Void handleUK() {
      System.out.println("UK");
      return null;
   }

   public Void handleWorld() {
      System.out.println("Big world");
      return null;
   }
}

enum FiscalZone {
   EU,
   CH,
   UK,
   WORLD,
   US
}