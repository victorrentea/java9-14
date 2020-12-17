package victor.training.java11;

public class TheyImplement {


   public static void main(String[] args) {
//      your are USING the interfafce
      ITheyImplement interfaceObject = new TheirImplem1();
      TheirInterfaceAdapter enhancedApi = new TheirInterfaceAdapter(interfaceObject);
      enhancedApi.utilityCallingMethod();
   }
}

class TheirInterfaceAdapter {
   private final  ITheyImplement delegate;

   TheirInterfaceAdapter(ITheyImplement delegate) {
      this.delegate = delegate;
   }
   public void method() {
       delegate.method();
   }

   void utilityCallingMethod() {
      delegate.method(); // + more stuff
   }
}


interface ITheyImplement {
   void method();
   // one more method here based on methd()
//   void utilityCallingMethod();
}


// =========================== you don't cotrol below

class TheirImplem1 implements ITheyImplement {
   @Override
   public void method() {

   }
}
class TheirImplem2 implements ITheyImplement {
   @Override
   public void method() {

   }
}