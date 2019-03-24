import java.util.*;

class Main {
  public static void main(String[] argv) {
    ArrayList<Person> list = new ArrayList<Person>();

    list.add(new Person("Adam", 2009));
    list.add(new Person("Janek", 2008));
    list.add(new Person("Daniel", 1989));

    HashSet<Person> set = new HashSet<Person>(list);

    System.out.println(list);
    System.out.println(set);

    System.out.println(Person.findInList(list, "Daniel", 1989));
    System.out.println(Person.findInSet(set, "Adam", 1989));
    System.out.println(Person.findInSet(set, "Daniel", 1989));
  }
}
