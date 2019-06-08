import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

class MyRenderer implements TableCellRenderer {
  public static void makeBold(Component c) {
    c.setFont(
      new Font(
        c.getFont().getName(),
        Font.BOLD,
        c.getFont().getSize()
      )
    );
  }

  public Component getTableCellRendererComponent(
    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column
  ) {
    Person person = (Person)value;
    JLabel label = new JLabel();

    label.setOpaque(true);
    label.setBackground(Color.WHITE);

    switch (column) {
      case 0: {
        label.setText(person.firstName.toString());
        break;
      }
      case 1: {
        label.setText(person.lastName.toString());
        break;
      }
      case 2: {
        Calendar c = new GregorianCalendar();
        c.setTime(person.dob);

        String weekday = c.getDisplayName(
          Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.FRENCH
        );

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setText(weekday);
        MyRenderer.makeBold(label);

        break;
      }
      case 3: {
        label.setOpaque(true);
        label.setBackground(person.color);
        label.setText("");
        break;
      }
      case 4: {
        label.setText(Integer.toString(person.height));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        break;
      }
      case 5: {
        label.setText(Integer.toString(person.weight));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        break;
      }
      case 6: {
        int bmi = person.getBMI();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        MyRenderer.makeBold(label);
   
        if (bmi < 18) {
          label.setBackground(Color.YELLOW);
        } else if (bmi > 25) {
          label.setBackground(Color.RED);
        }

        label.setText(Integer.toString(bmi));
        break;
      }
    }

    return label;
  }
}
