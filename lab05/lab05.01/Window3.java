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

    JPanel mainPanel = new JPanel(new BorderLayout());

    JTextArea textArea1 = new JTextArea();
    textArea1.setText("jTextArea1");

    mainPanel.add(textArea1, BorderLayout.CENTER);

    JPanel southPanel = new JPanel();
    southPanel.setLayout(new GridLayout(0, 3));

    JPanel buttonsPanel1 = new JPanel();
    buttonsPanel1.setLayout(new GridLayout(2, 2));
    for (int i = 1; i < 5; i++) {
      JButton currentButton = new JButton();
      currentButton.setText(String.format("B%2s", i).replace(' ', '0'));
      
      JPanel buttonContainer = new JPanel(new BorderLayout());

      buttonContainer.add(currentButton, BorderLayout.NORTH);
      buttonsPanel1.add(buttonContainer);
    }

    JPanel buttonsPanel2 = new JPanel();
    buttonsPanel2.setLayout(new GridLayout(2, 2));
    for (int i = 5; i < 9; i++) {
      JButton currentButton = new JButton();
      currentButton.setText(String.format("B%2s", i).replace(' ', '0'));

      JPanel buttonContainer = new JPanel(new BorderLayout());

      buttonContainer.add(currentButton, BorderLayout.NORTH);
      buttonsPanel2.add(buttonContainer);
    }
    
    JPanel textFieldsPanel = new JPanel();
    textFieldsPanel.setLayout(new GridLayout(0, 1)); 

    JTextField textField1 = new JTextField();
    textField1.setText("jTextField1");
    JTextField textField2 = new JTextField();
    textField2.setText("jTextField2");
    JTextField textField3 = new JTextField();
    textField3.setText("jTextField3");

    textFieldsPanel.add(textField1);
    textFieldsPanel.add(textField2);
    textFieldsPanel.add(textField3);

    southPanel.add(buttonsPanel1);
    southPanel.add(textFieldsPanel);
    southPanel.add(buttonsPanel2);

    mainPanel.add(southPanel, BorderLayout.SOUTH);

    this.add(mainPanel);
    this.pack();
  }
}
