/**
 Object to represet each side of the 3x3 cube.

 @author Nathen St. Germain
 @version Apr 20, 2017
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Side {
  private Square[] squares;

  /**
   Constructor for Side object.
   */
  public Side (String[] colour) {
    squares = new Square[9];

    for (int i = 0; i < 9; i++) {
      squares[i] = new Square(colour[i]);
    }
  }

  /**
   Get array of squares (JPanels).

   @return Array of JPanels
   */
  public JPanel[] getSquares () {
    JPanel[] panels;

    panels = new JPanel[9];

    for (int i = 0; i < 9; i++) {
      panels[i] = this.squares[i].getPanel();
    }

    return panels;
  }
}
