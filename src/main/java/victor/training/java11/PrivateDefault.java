package victor.training.java11;

import java.util.List;
import java.util.stream.Stream;

public class PrivateDefault {

   public static void main(String[] args) {
      //
      List<String> list = List.of("a", "c");
      list.stream();
   }
}


//abstract class BaseList extends List {
//   public Stream stream() {
//      return ;
//   }
//}

interface A {
   public static final int x = 1; // always constant
   default int m() {
//      x = 2;
      return 1;
   }
   abstract void f();
}
abstract class AAbstra {
   int x = 1;
   abstract protected void f();
   int m() {
      x ++;
      return 1;
   }
}
interface B {
   default int m() {
      return 2;
   }
}

class AB implements A,B{

   @Override
   public int m() {
      return A.super.m();
   }

   @Override
   public void f() {

   }
}


interface ICommChanel {
}
class SmsChannel implements ICommChanel {

}