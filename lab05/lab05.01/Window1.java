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

    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel northPanel = new JPanel(new GridLayout(0, 1));

    JTextField textField1 = new JTextField();
    textField1.setText("jTextField1");
    JPanel textField1Container = new JPanel(new BorderLayout());
    textField1Container.add(textField1, BorderLayout.NORTH);

    JTextField textField2 = new JTextField();
    textField2.setText("jTextField2");
    JPanel textField2Container = new JPanel(new BorderLayout());
    textField2Container.add(textField2, BorderLayout.NORTH);

    JTextField textField3 = new JTextField();
    textField3.setText("jTextField3");
    JPanel textField3Container = new JPanel(new BorderLayout());
    textField3Container.add(textField3, BorderLayout.NORTH);

    northPanel.add(textField1Container);
    northPanel.add(textField2Container);
    northPanel.add(textField3Container);
    
    JPanel southPanel = new JPanel(new GridLayout(1, 2));

    JTextArea textArea1 = new JTextArea();
    textArea1.setText("jTextArea1");
    southPanel.add(textArea1);
    
    JPanel buttonsPanel = new JPanel(new GridLayout(3, 2));

    for (int i = 1; i < 10; i++) {
      JButton currentButton = new JButton();
      currentButton.setText(String.format("B%2s", i).replace(' ', '0'));
      
      JPanel buttonContainer = new JPanel(new BorderLayout());

      buttonContainer.add(currentButton, BorderLayout.NORTH);
      buttonsPanel.add(buttonContainer);
    }

    southPanel.add(buttonsPanel);

    mainPanel.add(northPanel, BorderLayout.NORTH);
    mainPanel.add(southPanel, BorderLayout.CENTER);
    
    this.add(mainPanel);

    this.pack();
  }
}
