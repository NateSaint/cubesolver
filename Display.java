/**
 Class for displaying 3x3 cube using JFrame.  Contains methods to initialize
 JFrame and graphically display the cube to the user, and methods to call for
 the cube to be solved.

 @author Nathen St. Germain
 @version Apr 20 2017
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Display implements MouseListener, ActionListener {
  /*Main frame*/
  private JFrame frame;

  /*Panels for displaying cube*/
  private JPanel panel_cube;
  private JPanel panel_top, panel_bottom, panel_front, panel_back, panel_left, panel_right;
  private JPanel panel_fill0, panel_fill1, panel_fill2, panel_fill3, panel_fill4, panel_fill5;
  private JPanel panel_buttons;
  private JPanel[][] panels;

  /*JButtons*/
  private JButton button_solve;
  private JButton button_reset;
  private JButton button_quit;

  private ImageIcon icon;

  /*Dimensions for user screen*/
  private double width;
  private double height;

  /*Creating mouse listener*/
  private MouseListener listener;

  private String button_string;

  /**
   Constructor for Display class.

   @param title Title for JFrame
   */
  public Display (String title) {
    this.initFrame(title);
    this.initPanel();
    this.initButton();
    this.addPanel();
    this.addButton();
    this.setButton("default");
  }

  /**
   Graphically display a 2-D cube, display each side of the cube in a JFrame.

   @param cube A 3x3 cube object
   */
  public void displayCube (Cube cube) {
    this.panels = cube.getSides();

    this.panel_top.removeAll();
    this.panel_left.removeAll();
    this.panel_front.removeAll();
    this.panel_right.removeAll();
    this.panel_bottom.removeAll();
    this.panel_back.removeAll();

    for (int i = 0; i < 9; i++)
      this.panel_top.add(this.panels[0][i]);
    for (int i = 0; i < 9; i++)
      this.panel_left.add(this.panels[1][i]);
    for (int i = 0; i < 9; i++)
      this.panel_front.add(this.panels[2][i]);
    for (int i = 0; i < 9; i++)
      this.panel_right.add(this.panels[3][i]);
    for (int i = 0; i < 9; i++)
      this.panel_bottom.add(this.panels[4][i]);
    for (int i = 0; i < 9; i++)
      this.panel_back.add(this.panels[5][i]);

    this.panel_top.revalidate();
    this.panel_left.revalidate();
    this.panel_front.revalidate();
    this.panel_right.revalidate();
    this.panel_bottom.revalidate();
    this.panel_back.revalidate();

    this.addListenerPanel();
  }

  /**
   Initialize JFrame settings for use with displaying cube after.

   @param title Title to be displayed in the top bar of the JFrame
   */
  private void initFrame (String title) {
    this.frame = new JFrame(title);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.icon = new ImageIcon("icon.jpg");
    this.frame.setIconImage(this.icon.getImage());
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

    this.panel_buttons = new JPanel();

    this.panel_top.setLayout(new GridLayout(3,3));
    this.panel_front.setLayout(new GridLayout(3,3));
    this.panel_bottom.setLayout(new GridLayout(3,3));
    this.panel_back.setLayout(new GridLayout(3,3));
    this.panel_left.setLayout(new GridLayout(3,3));
    this.panel_right.setLayout(new GridLayout(3,3));

    this.panel_cube.setLayout(new GridLayout(4, 3));
  }

  /**
   Initialize JButtons.
   */
  private void initButton () {
    this.button_solve = new JButton ("Solve");
    this.button_reset = new JButton ("Reset");
    this.button_quit = new JButton ("Quit");

    this.button_solve.setName("solve");
    this.button_reset.setName("reset");
    this.button_quit.setName("quit");

    this.button_solve.addActionListener(this);
    this.button_reset.addActionListener(this);
    this.button_quit.addActionListener(this);
  }

  /**
   Add panels to cube panel which will be added to the main frame.
   */
  private void addPanel () {
    Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();

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
    this.frame.add(this.panel_cube, BorderLayout.CENTER);
    this.frame.add(this.panel_buttons, BorderLayout.SOUTH);

    this.width = scr.getWidth();
    this.height = scr.getHeight();

    this.panel_cube.setSize((int)(height/2.33), (int)((height/2.33) * 1.3333));
    this.panel_cube.setLocation(0, 0);
    this.panel_buttons.setLocation(0, (int)((height/2.33) * 1.3333) + 1);

    this.frame.setSize((int)(height/2.33), (int)((height/2.33) * 1.3333) + 60);
    this.frame.setLocationRelativeTo(null);
    this.frame.setVisible(true);
  }

  /**
   Add JButtons to buttons panel.
   */
  private void addButton () {
    this.panel_buttons.add(this.button_solve);
    this.panel_buttons.add(this.button_reset);
    this.panel_buttons.add(this.button_quit);
  }

  /**
   Add mouse listener to JPanels.
   */
  private void addListenerPanel () {
    String name;

    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 9; j++) {
        /*Code for identifying with mouse listener*/
        name = Integer.toString(i) + Integer.toString(j);

        this.panels[i][j].addMouseListener(this);
        this.panels[i][j].setName(name);
      }
    }
  }

  /**
   Action performed event for use with button click.

   @param event Action performed event
   */
  public void actionPerformed(ActionEvent event) {
    String name;

    name = ((JButton)event.getSource()).getName();

    if (name == "solve") {
      this.setButton("solve");
    }
    else if (name == "reset") {
      this.setButton("reset");
    }
    else if (name == "quit") {
      System.exit(0);
    }
  }

  /**
   Mouse clocked event implemented from MouseListener class.

   @param event Mouse clicked event
   */
  public void mouseClicked(MouseEvent event) {
    this.changeSquare(((JPanel)event.getSource()).getName());
  }

  public void mouseExited(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mousePressed(MouseEvent e) {}

  /**
   Call for the colour to be changed of the clicked square.

   @param key String to be parsed identifying clicked panel
   */
  private void changeSquare (String key) {
    int side;
    int square;
    Color myYellow;
    Color myOrange;

    myYellow = new Color(255, 255, 51);
    myOrange = new Color(255, 140, 0);
    side = Character.getNumericValue(key.charAt(0));
    square = Character.getNumericValue(key.charAt(1));

    if (this.panels[side][square].getBackground().equals(Color.WHITE))
      this.panels[side][square].setBackground(Color.GREEN);
    else if (this.panels[side][square].getBackground().equals(Color.GREEN))
      this.panels[side][square].setBackground(Color.RED);
    else if (this.panels[side][square].getBackground().equals(Color.RED))
      this.panels[side][square].setBackground(Color.BLUE);
    else if (this.panels[side][square].getBackground().equals(Color.BLUE))
      this.panels[side][square].setBackground(myYellow);
    else if (this.panels[side][square].getBackground().equals(myYellow))
      this.panels[side][square].setBackground(myOrange);
    else if (this.panels[side][square].getBackground().equals(myOrange))
      this.panels[side][square].setBackground(Color.WHITE);
  }

  /**
   Set solve instance variable.

   @param str String to set
   */
  public void setButton (String str) {
    this.button_string = str;
  }

  /**
   Get the current button pressed as a string.

   @return String, button as a string
   */
  public String getButton () {
    return this.button_string;
  }
}
