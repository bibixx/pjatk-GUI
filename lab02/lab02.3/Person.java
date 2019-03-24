import java.util.*;

class Person {
  public String name;
  public int yearOfBirth;

  public static boolean findInList(List<Person> list, String name, int yearOfBirth) {
    return list.contains(new Person(name, yearOfBirth));
  }

  public static boolean findInSet(Set<Person> set, String name, int yearOfBirth) {
    return set.contains(new Person(name, yearOfBirth));
  }

  public boolean equals(Object o) {
    Person p = (Person)o;

    // return p.name.equals(this.name) && p.yearOfBirth == this.yearOfBirth;
    return p.yearOfBirth == this.yearOfBirth;
  }

  // @Override
  // public int hashCode() {
  //   return this.yearOfBirth;
  // }

  public String toString() {
    return "Name: " + this.name + "; born: " + this.yearOfBirth;
  }

  public Person(String name, int yearOfBirth) {
    this.name = name;
    this.yearOfBirth = yearOfBirth;
  }
}
