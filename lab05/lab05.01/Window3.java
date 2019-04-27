import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Window1
 */
public class Window3 extends JFrame {
  public Window3() {
    this.setPreferredSize(new Dimension(512, 256));
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocation(512 * 2 + 10 * 2, 0);

    JPanel p = new JPanel();
    p.setLayout(new BorderLayout());

    JTextArea ta1 = new JTextArea();
    ta1.setText("jTextArea1");
    JPanel ta1p = new JPanel();
    ta1p.setLayout(new BorderLayout());
    ta1p.add(ta1, BorderLayout.NORTH);

    p.add(ta1, BorderLayout.CENTER);

    JPanel p2 = new JPanel();
    p2.setLayout(new GridLayout(0, 3));

    JPanel p3 = new JPanel();
    p3.setLayout(new GridLayout(2, 2));
    for (int i = 1; i < 5; i++) {
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

    JPanel p4 = new JPanel();
    p4.setLayout(new GridLayout(2, 2));
    for (int i = 5; i < 9; i++) {
      JButton b = new JButton();
      b.setText(String.format("B%2s", i).replace(' ', '0'));
      
      JPanel ptemp = new JPanel();
      JPanel ptemp2 = new JPanel();
      ptemp.setLayout(new FlowLayout());
      ptemp2.setLayout(new BorderLayout());

      ptemp.add(b, BorderLayout.NORTH);
      ptemp2.add(ptemp, BorderLayout.CENTER);
      p4.add(ptemp);
    }
    
    
    JPanel p5 = new JPanel();
    p5.setLayout(new GridLayout(0, 1)); 

    JTextField tf1 = new JTextField();
    tf1.setText("jTextField1");
    JTextField tf2 = new JTextField();
    tf2.setText("jTextField2");
    JTextField tf3 = new JTextField();
    tf3.setText("jTextField3");

    p5.add(tf1);
    p5.add(tf2);
    p5.add(tf3);

    p2.add(p3);
    p2.add(p5);
    p2.add(p4);

    p.add(p2, BorderLayout.SOUTH);

    this.add(p);
    this.pack();
  }
}
