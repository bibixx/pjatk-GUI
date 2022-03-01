import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

class Main {
  public static void main(String[] argv) {
    DefaultListModel<String> datesOneModel = new DefaultListModel<String>();
    DefaultListModel<String> datesTwoModel = new DefaultListModel<String>();

    RandomDate runner1 = new RandomDate("runner1", datesOneModel);
    RandomDate runner2 = new RandomDate("runner2", datesTwoModel);

    runner1.start();
    runner2.start();

    ActionListener onOne = e -> {
      System.out.println(1);
    };

    ActionListener onTwo = e -> {
      System.out.println(2);
    };

    SwingUtilities.invokeLater(() -> {
      new Window(datesOneModel, datesTwoModel, onOne, onTwo, runner1, runner2);
    });
  }
}

