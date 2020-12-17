package victor.training.java11;

 class UnknownClient {
    public static void main(String[] args) {
       InterfaceThatIImplement list = null;
       list.stream();
    }
}

interface InterfaceThatIImplement {
   void stream();
   //or java8:
//   default void stream() {
//      System.out.println("Same implem");
//   }
}

abstract class AbstractBase {
   public void stream() {
      System.out.println("Same implem");
   }
}

class MyImplem1 extends AbstractBase implements InterfaceThatIImplement {
}
class MyImplem2 extends AbstractBase implements InterfaceThatIImplement {

}