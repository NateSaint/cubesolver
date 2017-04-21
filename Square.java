/**
 Object to represent each square on a 3x3 cube object.

 @author Nathen St. Germain
 @version Apr 20, 2017
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Square {
  private String colour;
  private JPanel panel_square;

  /**
   Constructor for Square object.
   */
  public Square (String colour) {
    this.colour = colour;
    this.panel_square = new JPanel();
    this.panel_square.setBorder(BorderFactory.createLineBorder(Color.black, 2));

    this.setColour(this.colour);
  }

  /**
   Set the colour of the JPanel depending on the passed string.

   @param colour String of the colour
   */
  public void setColour (String colour) {
    if (colour == "white")
      this.panel_square.setBackground(Color.WHITE);
    else if (colour == "green")
      this.panel_square.setBackground(Color.GREEN);
    else if (colour == "red")
      this.panel_square.setBackground(Color.RED);
    else if (colour == "blue")
      this.panel_square.setBackground(Color.BLUE);
    else if (colour == "yellow")
      this.panel_square.setBackground(new Color(254, 254, 102));
    else if (colour == "orange")
      this.panel_square.setBackground(new Color(255, 140, 0));
  }

  /**
   Change the colour of the JPanel by one in the sequence, handles swapping
   through each colour.
   */
  public void updateColour () {
    if (this.colour == "white")
      this.setColour(this.colour = "green");
    else if (this.colour == "green")
      this.setColour(this.colour = "red");
    else if (this.colour == "red")
      this.setColour(this.colour = "blue");
    else if (this.colour == "blue")
      this.setColour(this.colour = "yellow");
    else if (this.colour == "yellow")
      this.setColour(this.colour = "orange");
    else if (this.colour == "orange")
      this.setColour(this.colour = "white");
  }

  /**
   Get the current colour of JPanel.

   @return colour of background of JPanel
   */
  public Color getColour () {
    return this.panel_square.getBackground();
  }

  /**
   Get JPanel representing square.

   @return JPanel representing square
   */
  public JPanel getPanel () {
    return this.panel_square;
  }
}
