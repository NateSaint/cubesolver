/**
 Object to represent the 3x3 cube.  Contains methods to initialize cube,
 create different permutations, check is solved, handle various
 rotations of the cube, and solve the cube (provide sequence).

 @author Nathen St. Germain
 @version Apr 20, 2017
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cube {
  private Side[] sides;

  /**
   Constructor for cube object.
   */
  public Cube () {
    sides = new Side[6];
  }

  /**
   Make the default, solved 3x3 cube.  The cube right out of the box.
   */
  public void makeDefaultCube () {
    /*Go through each side (6 sides) and initialize the colours*/
    for (int i = 0; i < 6; i++) {
      String colour;
      String[] sideColours;

      colour = "";
      sideColours = new String[9];

      /*Determine colour of side*/
      switch (i) {
        case 0: colour = "white"; break; /*top*/
        case 1: colour = "green"; break; /*left*/
        case 2: colour = "red"; break; /*front*/
        case 3: colour = "blue"; break; /*right*/
        case 4: colour = "yellow"; break; /*bottom*/
        case 5: colour = "orange"; break; /*back*/
      }

      /*All nine squares of side should be same colour*/
      for (int j = 0; j < 9; j++) {
        sideColours[j] = colour;
      }

      sides[i] = new Side(sideColours);
    }
  }

  /**
   Check if the 3x3 cube has been solved.

   @return boolean, true if solved, else false
   */
  public boolean checkSolved () {
    boolean solved = false;
    return solved;
  }

  /**
   Get arrays of squares for each side.

   @return 2-D array of JPanels
   */
  public JPanel[][] getSides() {
    JPanel[][] toReturn;

    toReturn = new JPanel[6][9];

    for (int i = 0; i < 6; i++) {
      JPanel[] temp = this.sides[i].getSquares();

      for (int j = 0; j < 9; j++) {
        toReturn[i][j] = temp[j];
      }
    }

    return toReturn;
  }

  /**
   Get the sequence for the cube object.
   */
  public void solve () {
    System.out.println("Sequence to solve cube:");
  }

  public void top_CW () {
  }

  public void top_CCW () {
  }
}
