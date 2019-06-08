import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;

public class Window extends JFrame {
  public Window() {
    JPanel container = new JPanel(new BorderLayout());

    JLabel fileNameHeader = new JLabel("", SwingConstants.CENTER);
    container.add(fileNameHeader, BorderLayout.NORTH);

    JTextArea fileContents = new JTextArea();

    fileContents.setWrapStyleWord(true);
    fileContents.setLineWrap(true);
    fileContents.setEditable(false);
    fileContents.setFocusable(false);

    JScrollPane scroll = new JScrollPane(
      fileContents,
      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
    );

    container.add(scroll, BorderLayout.CENTER);

    JPanel buttons = new JPanel();
    JButton fileButton = new JButton("Choose file");
    JButton exitButton = new JButton("Exit");

    exitButton.addActionListener(e -> {
      System.exit(0);
    });

    JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    fileButton.addActionListener(e -> {
      int returnValue = fileChooser.showOpenDialog(null);

      if (returnValue == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();

        Scanner scan;
        try {
          fileNameHeader.setText(selectedFile.getName());
          scan = new Scanner(selectedFile);
          scan.useDelimiter("\\Z");
          String content = scan.next();
          scan.close();

          fileContents.setText(content);
        } catch (FileNotFoundException e1) {
          e1.printStackTrace();
        }
      }
    });

    buttons.add(fileButton);
    buttons.add(exitButton);
    container.add(buttons, BorderLayout.SOUTH);

    this.add(container);

    this.setPreferredSize(new Dimension(500, 400));

    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
