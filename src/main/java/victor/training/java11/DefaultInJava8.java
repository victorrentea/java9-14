package victor.training.java11;

import javax.xml.validation.Validator;

public class DefaultInJava8 {
}


//bad example

//interface Validatable {
//   default void validate() {
//      Validator validator = null;// hocus pocus, gimme a validator;
//      validator.validate(this);
//   }
//}
//abstract class BaseEntity {
//
//}
//class Entity1  extends BaseEntity implements Validatable, IWantThatFuncToo {
//
//}
//
//class Client {
//   public static void main(String[] args) {
//      Entity1 e1 = null;
//      e1.validate();
//   }
//}

interface I {
   default void m1() {
      privateInInterface();
   }

   private void privateInInterface() {
      System.out.println("SharedCode");
   }

   default void m2() {
      privateInInterface();
   }
}

class Client {
   public static void main(String[] args) {
//      I i;
//      i.m1();
//      i.m2();
   }
}
class Implementer implements  I {
   public void method() {

   }
}


interface IA {
   default void method() {
   }
}

interface IB {
   default void method() {
   }
}
class DiamondOfDefault implements  IA, IB {

   @Override
   public void method() {
      IA.super.method();
   }
}