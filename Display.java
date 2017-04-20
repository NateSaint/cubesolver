import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Display {
  private JFrame frame;

  /**
   Constructor for Display class.

   @param title Title for JFrame
   */
  public Display (String title) {
    this.initFrame(title);
  }

  /**
   Graphically display a 2-D cube, display each side of the cube in a JFrame.

   @param cube A 3x3 cube object
   */
  public void displayCube (Cube cube) {
    /**
    CODE HERE
    */
    this.frame.pack();
    this.frame.setVisible(true);
  }

  //ON BUTTON CLICK GET WHAT THE USER HAS INPUTTED INTO THE CBE BY CLICKING AND
  //UNTIL THEY DECIDE ON A COLOUR OF A SQUARE

  //.getBackground() in square.java

  /**
   Initialize JFrame for use with displaying cube after.

   @param title Title to be displayed in the top bar of the JFrame
   */
  private void initFrame (String title) {
    this.frame = new JFrame(title);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
