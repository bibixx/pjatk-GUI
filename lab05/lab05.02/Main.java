import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

class Main extends JFrame {
  public static void main(String[] argv) {
    SwingUtilities.invokeLater(() -> {
      new Main();
    });
  }

  public Main() {
    this.setVisible(true);
    this.setPreferredSize(new Dimension(512, 256));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);

    slider.setMajorTickSpacing(10);
    slider.setMinorTickSpacing(1);
    slider.setPaintTicks(true);
    slider.setPaintLabels(true);

    JPanel panel = new JPanel(new BorderLayout());
    panel.add(slider, BorderLayout.SOUTH);

    MyPanel myPanel = new MyPanel(slider);
    panel.add(myPanel, BorderLayout.CENTER);

    slider.addChangeListener((e) -> {
      myPanel.repaint();
    });

    this.add(panel);
    this.pack();
  }
}

