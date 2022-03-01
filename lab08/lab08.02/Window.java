import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Window extends JFrame {
  private JButton buttonOne;
  private JButton buttonTwo;

  public void toggleButtonOne() {
    this.toggleButton(this.buttonOne);
  }

  public void toggleButtonTwo() {
    this.toggleButton(this.buttonTwo);
  }

  private void toggleButton(JButton button) {
    String text = button.getText();

    if (text.equals("SUSP")) {
      button.setText("GO!");
    } else {
      button.setText("SUSP");
    }
  }

  public Window(
    DefaultListModel<String> datesOneModel,
    DefaultListModel<String> datesTwoModel,
    ActionListener onOne,
    ActionListener onTwo,
    RandomDate runner1,
    RandomDate runner2
  ) {
    JPanel container = new JPanel(new GridLayout(1, 2));

    JPanel datesOneContainer = new JPanel(new BorderLayout());
    JPanel datesTwoContainer = new JPanel(new BorderLayout());

    JList<String> listOne = new JList<String>(datesOneModel);
    JScrollPane scrollableListOne = new JScrollPane(listOne);
    this.buttonOne = new JButton("SUSP");
    this.buttonOne.addActionListener(onOne);
    this.buttonOne.addActionListener(e -> {
      this.toggleButtonOne();
      runner1.toggle();
    });
    datesOneContainer.add(scrollableListOne, BorderLayout.CENTER);
    datesOneContainer.add(buttonOne, BorderLayout.SOUTH);

    JList<String> listTwo = new JList<String>(datesTwoModel);
    JScrollPane scrollableListTwo = new JScrollPane(listTwo);
    this.buttonTwo = new JButton("SUSP");
    this.buttonTwo.addActionListener(onTwo);
    this.buttonTwo.addActionListener(e -> {
      this.toggleButtonTwo();
      runner2.toggle();
    });
    datesTwoContainer.add(scrollableListTwo, BorderLayout.CENTER);
    datesTwoContainer.add(buttonTwo, BorderLayout.SOUTH);

    container.add(datesOneContainer);
    container.add(datesTwoContainer);

    this.add(container);

    this.setPreferredSize(new Dimension(800, 400));

    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
