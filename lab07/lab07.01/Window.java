import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Window extends JFrame {
  public Window(List<Person> people) {
    TableModel myModel = new TableModel(people);
    JTable table = new JTable(myModel);
    table.setShowGrid(true);
    table.setShowHorizontalLines(true);
    table.setShowVerticalLines(true);
    table.setDefaultRenderer(Object.class, new MyRenderer());
    table.setPreferredScrollableViewportSize(new Dimension(480, 70));

    JScrollPane scrollPane = new JScrollPane(table);

    this.add(scrollPane);

    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
