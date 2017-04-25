/**
 Class used to apply Corners first method.

 @author Nathen St. Germain
 */
public class CubeSolver {
  /**
   Main method.
   */
  public static void main(String [] args) {
    Display display;
    Cube cube;

    /*Initializing variables/objects*/
    display = new Display("3x3 Cube Solver - Nathen St. Germain");
    cube = new Cube();

    /*Create and display default cube (fully solved)*/
    cube.makeDefaultCube();
    display.displayCube(cube);
  }
}
