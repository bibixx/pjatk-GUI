import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Person {
  public String firstName;
  public String lastName;
  public Date dob;
  public Color color;
  public int height;
  public int weight;

  public Person(
    String firstName,
    String lastName,
    Date dob,
    Color color,
    int height,
    int weight
  ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = dob;
    this.color = color;
    this.height = height;
    this.weight = weight;
  }

  public int getBMI() {
    float weight = this.weight;
    float height = this.height;

    return (int)Math.round(weight / (Math.pow(height / 100, 2)));
  }
}
