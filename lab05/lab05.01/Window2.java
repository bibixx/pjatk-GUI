import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Window1
 */
public class Window2 extends JFrame {
  public Window2() {
    this.setPreferredSize(new Dimension(512, 256));
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocation(512 + 10 * 1, 0);

    JPanel p = new JPanel();
    p.setLayout(new BorderLayout());
    
    JTextArea tf1 = new JTextArea();
    tf1.setText("jTextArea1");
    JTextArea tf2 = new JTextArea();
    tf2.setText("jTextArea2");
    JTextField tf3 = new JTextField();
    tf3.setText("jTextField4");

    p.add(tf1, BorderLayout.WEST);
    p.add(tf2, BorderLayout.EAST);
    p.add(tf3, BorderLayout.SOUTH);

    JPanel p3 = new JPanel();
    p3.setLayout(new GridLayout(3, 2));
    for (int i = 1; i < 13; i++) {
      JButton b = new JButton();
      b.setText(String.format("B%2s", i).replace(' ', '0'));

      JPanel ptemp = new JPanel();
      JPanel ptemp2 = new JPanel();
      ptemp.setLayout(new BorderLayout());
      ptemp2.setLayout(new BorderLayout());

      ptemp.add(b, BorderLayout.NORTH);
      ptemp2.add(ptemp, BorderLayout.CENTER);
      p3.add(ptemp);
    }

    p.add(p3, BorderLayout.CENTER);

    this.add(p);
    this.pack();
  }
}
