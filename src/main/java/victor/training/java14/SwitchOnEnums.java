package victor.training.java14;

public class SwitchOnEnums {

   public double m(FiscalZone zone, double baseAmount) {
      return switch (zone) {
         case CH, EU -> 0;
         case UK -> baseAmount * .01;
         case WORLD -> baseAmount * .1;
      };
   }
}

enum FiscalZone {
   EU,
   CH,
   UK,
   WORLD,
   US
}