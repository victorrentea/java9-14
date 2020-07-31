package victor.training.java11;

public class DefaultMethodsContinues {

   public static void main(String[] args) {
      I i = new IImpl();

      i.setUpperX("a"); // convenience for the caller.
   }
}
interface I {
   void setX(String x);
   default void setUpperX(String x) {
      invisibleToOurClient(x);
   }

   private void invisibleToOurClient(String x) {
      setX(x.toUpperCase());
   }

   default void setUpperX2(String x) {
      invisibleToOurClient(x);
   }
   default void setUpperX3(String x) {
      invisibleToOurClient(x);
   }
   default String toUp(String s) {
      return s.toLowerCase(); // NO; should always make use
      // of some abstract instance method defined in the same interface
   }
}

class IImpl implements I {
   String x;
   @Override
   public void setX(String x) {
      this.x = x;
   }
}
