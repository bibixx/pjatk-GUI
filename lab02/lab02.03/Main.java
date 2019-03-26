import java.util.*;
import javax.swing.*;

class Main {
  private static Map<String, String> showDialog() {
    JTextField nameField = new JTextField(5);
    JTextField birthyearField = new JTextField(5);
    JPanel myPanel = new JPanel();

    BoxLayout layout = new BoxLayout(myPanel, BoxLayout.PAGE_AXIS);
    myPanel.setLayout(layout);

    myPanel.add(new JLabel("Imię"));
    myPanel.add(nameField);
    myPanel.add(Box.createHorizontalStrut(15));
    myPanel.add(new JLabel("Data urodzenia"));
    myPanel.add(birthyearField);

    int result = JOptionPane.showConfirmDialog(
      null,
      myPanel,
      "Podaj dane",
      JOptionPane.OK_CANCEL_OPTION
    );

    if (result == JOptionPane.OK_OPTION) {
      Map<String, String> map = new HashMap<String, String>();
      map.put("name", nameField.getText());
      map.put("birthYear", birthyearField.getText());

      return map;
    }

    return null;
  }

  public static void main(String[] argv) {
    ArrayList<Person> list = new ArrayList<Person>();
    Map<String, String> newPerson;
    
    while ((newPerson = showDialog()) != null) {
      int year;

      try {
        year = Integer.parseInt(newPerson.get("birthYear"));
      } catch (NumberFormatException e) {
        continue;
      }

      list.add(new Person(
        newPerson.get("name"),
        year
      ));
    };

    HashSet<Person> set = new HashSet<Person>(list);

    System.out.println(list);
    System.out.println(set);

    System.out.println(Person.findInList(list, "Daniel", 1989));
    System.out.println(Person.findInSet(set, "Adam", 1989));
    System.out.println(Person.findInSet(set, "Daniel", 1989));
  }
}
