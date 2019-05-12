import javax.swing.*;
import javax.swing.BorderFactory;

import java.awt.*;

public class Main extends JFrame {
  private void showWarning(String msg) {
    JOptionPane.showMessageDialog(
      this,
      msg,
      "WARNING",
      JOptionPane.WARNING_MESSAGE
    );
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
      () -> {
        new Main();
      }
    );
  }

  public Main(){
    JPanel panel = new JPanel(new BorderLayout());
    DefaultListModel<Person> lm = new DefaultListModel<Person>();
    JList<Person> list = new JList<Person>(lm);
    list.setCellRenderer(new PersonRenderer());
    
    JScrollPane listScroller = new JScrollPane(list);
    listScroller.setPreferredSize(new Dimension(250, 80));
    panel.add(listScroller, BorderLayout.CENTER);
    
    JPanel optionsPanel = new JPanel(new GridLayout(0, 1));

    // setTitledBorder
    JSlider heightSlider = new JSlider(100, 200, 150);
    heightSlider.setMajorTickSpacing(10);
    heightSlider.setMinorTickSpacing(1);
    heightSlider.setPaintTicks(true);
    heightSlider.setPaintLabels(true);
    heightSlider.setBorder(BorderFactory.createTitledBorder("Height [cm]"));
    optionsPanel.add(heightSlider);

    JSlider weightSlider = new JSlider(40, 120, 80);
    weightSlider.setMajorTickSpacing(10);
    weightSlider.setMinorTickSpacing(1);
    weightSlider.setPaintTicks(true);
    weightSlider.setPaintLabels(true);
    weightSlider.setBorder(BorderFactory.createTitledBorder("Weight [kg]"));
    optionsPanel.add(weightSlider);
    
    JPanel nameSizePanel = new JPanel();
    optionsPanel.add(nameSizePanel);
    
    nameSizePanel.add(new JLabel("Name: "));
    JTextField nameField = new JTextField("", 15);
    nameSizePanel.add(nameField);

    nameSizePanel.add(new JLabel("Size: "));
    JComboBox<Size> sizeDropdown = new JComboBox<Size>(Size.values());
    nameSizePanel.add(sizeDropdown);
    sizeDropdown.setSelectedItem(Size.M);
    
    JButton addPersonButton = new JButton("Add person");
    nameSizePanel.add(addPersonButton);
    
    JButton exitButton = new JButton("Exit");
    nameSizePanel.add(exitButton);

    panel.add(optionsPanel, BorderLayout.SOUTH);

    this.add(panel);

    this.setPreferredSize(new Dimension(600, 500));
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();

    addPersonButton.addActionListener(e -> {
      int height = heightSlider.getValue();
      int weight = weightSlider.getValue();
      String name = nameField.getText();
      Size size = (Size) sizeDropdown.getSelectedItem();

      if (name.isEmpty()) {
        this.showWarning("No name specified");

        return;
      }

      lm.addElement(new Person(height, weight, name, size));

      heightSlider.setValue(150);
      weightSlider.setValue(80);
      nameField.setText("");
      sizeDropdown.setSelectedItem(Size.M);
    });
    exitButton.addActionListener(e -> System.exit(0));
  }
}
