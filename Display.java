import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Display {
  private JFrame frame;

  public Display (String name) {
    this.initFrame(name);
  }

  private void initFrame (String name) {
    this.frame = new JFrame(name);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.pack();
    this.frame.setVisible(true);
  }
}
