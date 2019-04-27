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
public class Window1 extends JFrame {
  public Window1() {
    this.setPreferredSize(new Dimension(512, 256));
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel p = new JPanel();
    p.setLayout(new GridLayout(0, 1));

    JTextField tf1 = new JTextField();
    tf1.setText("jTextField1");
    JTextField tf2 = new JTextField();
    tf2.setText("jTextField2");
    JTextField tf3 = new JTextField();
    tf3.setText("jTextField3");

    p.add(tf1);
    p.add(tf2);
    p.add(tf3);
    
    JPanel p2 = new JPanel();
    p2.setLayout(new GridLayout(1, 2));

    JTextArea ta1 = new JTextArea();
    ta1.setText("jTextArea1");
    p2.add(ta1);
    
    JPanel p3 = new JPanel();

    p3.setLayout(new GridLayout(3, 2));
    for (int i = 1; i < 10; i++) {
      JButton b = new JButton();
      b.setText(String.format("B%2s", i).replace(' ', '0'));

      p3.add(b);
    }

    p2.add(p3);
    p.add(p2);

    this.pack();

    this.add(p);
  }
}
