package victor.training.java11;

public class SealedPlay {
   public static void main(String[] args) {
//      Shape shape;
//      switch (shape) {
//         case Square(edge) -> System.out.println(edge);
//      }
   }
}

// var Rectangle(w,h) = methodReturnsRect()

sealed interface Shape permits Square, Circle, Insane {

}

abstract class AbstractShape {
}

record Square(int edge) implements Shape {

}
record Circle(double radius) implements Shape {

}


sealed class Insane implements Shape permits Insane2, Insane1 {

}

non-sealed class Insane2 extends Insane {

}

class Insane2A extends Insane2 {

}
class Insane2B extends Insane2 {

}

final class Insane1 extends Insane {

}