import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class MyPanel extends JPanel {
  private JSlider slider;

  public MyPanel(JSlider slider) {
    this.slider = slider;
  }

  public void paintComponent(Graphics g) {
    float value = (float)slider.getValue() / 100;

    g.setColor(new Color(0, (int)(255 * value), 0));

    int s = (int)(Math.min(getWidth(), getHeight()) * value);
    g.fillRect(
      getWidth() / 2 - s / 2,
      getHeight() / 2 - s / 2,
      s,
      s
    );
  }
}
