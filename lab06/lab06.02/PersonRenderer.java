import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class PersonRenderer extends JLabel implements ListCellRenderer<Person> {
  @Override
  public Component getListCellRendererComponent(
    JList<?extends Person> list,
    Person person,
    int index,
    boolean isSelected,
    boolean cellHasFocus
  ) {
    this.setOpaque(false);
    this.setText(person.toString());

    if (person.size == Size.XS) {
      this.setOpaque(true);
      this.setBackground(Color.GREEN);
    }
    if (person.size == Size.XL) {
      this.setOpaque(true);
      this.setBackground(Color.RED);
    }

    return this;
  }
}
