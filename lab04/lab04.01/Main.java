import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
  public static void main(String[] argv) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("data.txt"));

    String line;
    ArrayList<Person> people = new ArrayList<Person>();

    while ((line = reader.readLine()) != null) {
      String[] lineElements = line.split(" +");

      Car car = null;
      
      if (lineElements.length > 2) {
        car = new Car(lineElements[2], lineElements[3], lineElements[4], lineElements[5]);
      }

      people.add(new Person(
        lineElements[0],
        Integer.parseInt(lineElements[1]),
        car
      ));
    }

    System.out.println(
      Person.findAllCars(people)
    );

    System.out.println(
      Person.findOwners(people, "Mercedes")
    );

    System.out.println(
      Person.findColor(people, "Annie", 1993)
    );
  }
}

