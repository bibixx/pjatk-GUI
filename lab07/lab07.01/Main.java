import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

class Main {
  public static void main(String[] argv) throws IOException, NumberFormatException, ParseException {
    ArrayList<Person> people = new ArrayList<Person>();
    BufferedReader br = new BufferedReader(new FileReader("data.csv"));
    String line;
    SimpleDateFormat dateFromat = new SimpleDateFormat("yyyy-MM-dd");

    while ((line = br.readLine()) != null) {
      String[] data = line.split(" +");
      String[] colorStrings = data[3].split(",");
      int red = Integer.parseInt(colorStrings[0]);
      int blue = Integer.parseInt(colorStrings[1]);
      int green = Integer.parseInt(colorStrings[2]);

      people.add(
        new Person(
          data[0],
          data[1],
          dateFromat.parse(data[2]),
          new Color(
            red,
            blue,
            green
          ),
          Integer.parseInt(data[4]),
          Integer.parseInt(data[5])
        )
      );
    }

    br.close();

    SwingUtilities.invokeLater(() -> {
      new Window(people);
    });
  }
}

