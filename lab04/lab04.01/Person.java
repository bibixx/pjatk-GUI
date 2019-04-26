import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Person
 */
public class Person {
  public String name;

  public int yearOfBirth;

  public Car car;

  public Person(String name, int yearOfBirth, Car car) {
    this.name = name;
    this.yearOfBirth = yearOfBirth;
    this.car = car;
  }

  @Override
  public String toString() {
    return this.name + " " + this.yearOfBirth + " " + this.car;
  }

  public static List<Car> findAllCars(List<Person> people) {
    ArrayList<Car> carsList = new ArrayList<Car>();
    for (Person p : people) {
      if (p.car != null) {
        carsList.add(p.car);
      }
    }

    return carsList;
  }

  public static List<Person> findOwners(List<Person> list, String carName) {
    ArrayList<Person> people = new ArrayList<Person>();

    for (Person p : list) {
      if (p.car != null) {
        if (p.car.name.equals(carName)) {
          people.add(p);
        }
      }
    }

    return people;
  }

  public static Color findColor(List<Person> list, String name, int year) {
    for (Person p : list) {
      if (p.name.equals(name) && p.yearOfBirth == year) {
        return p.car.color;
      }
    }

    return null;
  }
}
