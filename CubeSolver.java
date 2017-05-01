/**
 Class used to apply Corners first method.

 @author Nathen St. Germain
 */
public class CubeSolver {
  private static Display display;
  private static Cube cube;

  /**
   Main method.
   */
  public static void main(String [] args) {
    boolean run;

    /*Initializing variables/objects*/
    display = new Display("3x3 Cube Solver - Nathen St. Germain");
    cube = new Cube();
    run = true;

    /*Create and display default cube (fully solved)*/
    cube.makeDefaultCube();
    display.displayCube(cube);

    while (run == true) {
      System.out.print("");
      if (display.getButton() == "solve") {
        cube.solve();
        display.setButton("default");
      }
      else if (display.getButton() == "reset") {
        cube.makeDefaultCube();
        display.displayCube(cube);
        display.setButton("default");
      }
      else;
    }
  }
}
