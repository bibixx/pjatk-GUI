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
public class Window1 extends JFrame {
  public Window1() {
    this.setPreferredSize(new Dimension(512, 256));
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel p0 = new JPanel();
    p0.setLayout(new BorderLayout());
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(0, 1));

    JTextField tf1F = new JTextField();
    tf1F.setText("jTextField1");
    JPanel tf1 = new JPanel();
    tf1.setLayout(new BorderLayout());
    tf1.add(tf1F, BorderLayout.NORTH);

    JTextField tf2F = new JTextField();
    tf2F.setText("jTextField2");
    JPanel tf2 = new JPanel();
    tf2.setLayout(new BorderLayout());
    tf2.add(tf2F, BorderLayout.NORTH);

    JTextField tf3F = new JTextField();
    tf3F.setText("jTextField3");
    JPanel tf3 = new JPanel();
    tf3.setLayout(new BorderLayout());
    tf3.add(tf3F, BorderLayout.NORTH);

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
      
      JPanel ptemp = new JPanel();
      JPanel ptemp2 = new JPanel();
      ptemp.setLayout(new BorderLayout());
      ptemp2.setLayout(new BorderLayout());

      ptemp.add(b, BorderLayout.NORTH);
      ptemp2.add(ptemp, BorderLayout.CENTER);
      p3.add(ptemp);
    }

    p2.add(p3);
    // p.add(p2);

    p0.add(p, BorderLayout.NORTH);
    p0.add(p2, BorderLayout.CENTER);

    this.pack();

    this.add(p0);
  }
}
