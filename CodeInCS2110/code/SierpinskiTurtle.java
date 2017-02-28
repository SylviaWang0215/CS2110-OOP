public class SierpinskiTurtle extends Turtle {
  
  /** draw a sierpinski triangle with the top point
    * at the turtle's current location */
  public void drawSierpinski(double sideLength, int depth) {
      throw new UnsupportedOperationException();
  }
  
  
  
  public static void main(String[] args) {
    SierpinskiTurtle t= new SierpinskiTurtle();
    t.addAngle(90);
    t.liftPen();
    t.move(200);
    t.putPenDown();
    
    t.drawSierpinski(400, 2);
  }
}