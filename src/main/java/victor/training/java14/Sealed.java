package victor.training.java14;

import victor.training.java14.X.X1;
import victor.training.java14.X.X1.X1A;
import victor.training.java14.X.X2;
import victor.training.java14.X.X3;

import java.util.List;

public class Sealed {
   public static void main(String[] args) {
      ASTNode node = new Literal("2");
      {
         IList x = NilEnum.NADA;
      }
      print(node);
   }

   private static void print(ASTNode node) {
      // le printez in fct de tip, diferit

//      switch ()
      if (node instanceof Literal l) {
         System.out.print(l.val());
      } else if (node instanceof BinaryExpression b) {
         print(b.node1());
         System.out.print(" " + b.operand() + " ");
         print(b.node2());
      } else {
         throw new IllegalArgumentException();
      }
   }
}


sealed abstract class X permits X1, X2, X3 {
   sealed static class X1 extends X permits X1A {
      final static class X1A extends X1 {

      }
   }
   final static class X2 extends X {

   }
   non-sealed static class X3 extends X {

   }


}
class Magarie  extends X3 {

}
class Porcarie  extends X3 {
}

// Control
sealed interface ASTNode permits Literal, BinaryExpression {

}
record Literal(String val) implements ASTNode {

}
record BinaryExpression(ASTNode node1, char operand,  ASTNode node2) implements ASTNode {
}


sealed interface IList permits Nil, MyList, NilEnum  {

}

final class Nil implements IList {}
non-sealed abstract class  MyList implements IList {
}
enum NilEnum implements IList {
   NADA
}