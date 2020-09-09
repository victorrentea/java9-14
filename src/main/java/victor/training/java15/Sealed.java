package victor.training.java15;


import victor.training.java15.Shape.Circle;
import victor.training.java15.Shape.Square;

sealed interface Shape permits Square, Circle {

   record Square(int edge) implements Shape {

   }
   record Circle(int edge) implements Shape {
   }
}








