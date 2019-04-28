import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Window1
 */
public class Window2 extends JFrame {
  public Window2() {
    this.setPreferredSize(new Dimension(512, 256));
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocation(512 + 10 * 1, 0);

    JPanel mainPanel = new JPanel(new BorderLayout());
    
    JTextArea textArea1 = new JTextArea();
    textArea1.setText("jTextArea1");
    JTextArea textArea2 = new JTextArea();
    textArea1.setText("jTextArea2");
    JTextArea textArea3 = new JTextArea();
    textArea1.setText("jTextArea3");

    mainPanel.add(textArea1, BorderLayout.WEST);
    mainPanel.add(textArea2, BorderLayout.EAST);
    mainPanel.add(textArea3, BorderLayout.SOUTH);

    JPanel buttonsPanel = new JPanel(new GridLayout(3, 2));
    for (int i = 1; i < 13; i++) {
      JButton currentButton = new JButton();
      currentButton.setText(String.format("B%2s", i).replace(' ', '0'));

      JPanel buttonContainer = new JPanel(new BorderLayout());

      buttonContainer.add(currentButton, BorderLayout.NORTH);
      buttonsPanel.add(buttonContainer);
    }

    mainPanel.add(buttonsPanel, BorderLayout.CENTER);

    this.add(mainPanel);
    this.pack();
  }
}
