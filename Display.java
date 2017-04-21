/**
 Class for displaying 3x3 cube using JFrame.  Contains methods to initialize
 JFrame and graphically display the cube to the user.

 @author Nathen St. Germain
 @version Apr 20 2017
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Display {
  private JFrame frame;
  private JPanel panel_cube;
  private JPanel panel_top, panel_bottom, panel_front, panel_back, panel_left, panel_right;
  private JPanel panel_fill0, panel_fill1, panel_fill2, panel_fill3, panel_fill4, panel_fill5;

  /**
   Constructor for Display class.

   @param title Title for JFrame
   */
  public Display (String title) {
    this.initFrame(title);
    this.initPanel();
    this.addPanel();
  }

  /**
   Graphically display a 2-D cube, display each side of the cube in a JFrame.

   @param cube A 3x3 cube object
   */
  public void displayCube (Cube cube) {
    JPanel[][] panels;

    panels = cube.getSides();

    for (int i = 0; i < 9; i++)
      this.panel_top.add(panels[0][i]);
    for (int i = 0; i < 9; i++)
      this.panel_left.add(panels[1][i]);
    for (int i = 0; i < 9; i++)
      this.panel_front.add(panels[2][i]);
    for (int i = 0; i < 9; i++)
      this.panel_right.add(panels[3][i]);
    for (int i = 0; i < 9; i++)
      this.panel_bottom.add(panels[4][i]);
    for (int i = 0; i < 9; i++)
      this.panel_back.add(panels[5][i]);
  }

  /**
   Initialize JFrame settings for use with displaying cube after.

   @param title Title to be displayed in the top bar of the JFrame
   */
  private void initFrame (String title) {
    this.frame = new JFrame(title);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setBackground(Color.BLACK);
  }

  /**
   Initialize JPanel settings.  Set the layout of panel holding the cube.
   */
  private void initPanel () {
    this.panel_cube = new JPanel();

    this.panel_top = new JPanel();
    this.panel_front = new JPanel();
    this.panel_bottom = new JPanel();
    this.panel_back = new JPanel();
    this.panel_left = new JPanel();
    this.panel_right = new JPanel();

    this.panel_fill0 = new JPanel();
    this.panel_fill1 = new JPanel();
    this.panel_fill2 = new JPanel();
    this.panel_fill3 = new JPanel();
    this.panel_fill4 = new JPanel();
    this.panel_fill5 = new JPanel();

    this.panel_top.setLayout(new GridLayout(3,3));
    this.panel_front.setLayout(new GridLayout(3,3));
    this.panel_bottom.setLayout(new GridLayout(3,3));
    this.panel_back.setLayout(new GridLayout(3,3));
    this.panel_left.setLayout(new GridLayout(3,3));
    this.panel_right.setLayout(new GridLayout(3,3));

    this.panel_cube.setLayout(new GridLayout(4, 3));
  }

  /**
   Add panels to cube panel which will be added to the main frame.
   */
  private void addPanel () {
    /*Row one*/
    this.panel_cube.add(this.panel_fill0);
    this.panel_cube.add(this.panel_top);
    this.panel_cube.add(this.panel_fill1);

    /*Row two*/
    this.panel_cube.add(this.panel_left);
    this.panel_cube.add(this.panel_front);
    this.panel_cube.add(this.panel_right);

    /*Row three*/
    this.panel_cube.add(this.panel_fill2);
    this.panel_cube.add(this.panel_bottom);
    this.panel_cube.add(this.panel_fill3);

    /*Row four*/
    this.panel_cube.add(this.panel_fill4);
    this.panel_cube.add(this.panel_back);
    this.panel_cube.add(this.panel_fill5);

    /*Add cube panel to frame*/
    this.frame.add(this.panel_cube);

    this.frame.setSize(300,400);
    this.frame.setVisible(true);
  }
}
