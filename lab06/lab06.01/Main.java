import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.regex.*;

public class Main extends JFrame {
  ListModel listModel;

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
      () -> {
        new Main();
      }
    );
  }

  private void showWarning(String msg) {
    JOptionPane.showMessageDialog(
      this,
      msg,
      "WARNING",
      JOptionPane.WARNING_MESSAGE
    );
  }

  private void handleCommand(String text) {
    Pattern p = Pattern.compile("([^ ]+) ?(.*)");
      Matcher m = p.matcher(text);
      if (m.matches()) {
        String command = m.group(1);
        String argument = m.group(2);

        switch (command) {
          case "add": {
            if (argument == null) {
              this.showWarning("No argument specified");
            }

            if (!listModel.add(argument)) {
              this.showWarning("Entry \"" + argument + "\" already exists");
            }

            break;
          }
          case "rm":
          case "remove":
          case "del": {
            if (argument == null) {
              this.showWarning("No argument specified");
            }

            if (!listModel.remove(argument)) {
              this.showWarning("Entry \"" + argument + "\" doesn't exist");
            }

            break;
          }
          case "quit": {
            System.exit(0);
            break;
          }
          default: {
            this.showWarning("Unknown command");
            break;
          }
        }
      }
    }

    public Main(){
      JPanel panel = new JPanel(new BorderLayout());
      JTextField textField = new JTextField();
      this.listModel = new ListModel();

      JList<String> list = new JList<String>(this.listModel);

      JScrollPane listScroller = new JScrollPane(list);
      listScroller.setPreferredSize(new Dimension(250, 80));

      panel.add(listScroller, BorderLayout.CENTER);
      panel.add(textField, BorderLayout.SOUTH);
      this.add(panel);

      this.setPreferredSize(new Dimension(400, 200));
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.pack();

      textField.addActionListener(e -> {
        String text = textField.getText();

        this.handleCommand(text);

        textField.setText("");
      });
    }
}
