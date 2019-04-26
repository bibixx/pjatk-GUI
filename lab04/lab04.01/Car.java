import java.awt.Color;

/**
 * Car
 */
public class Car {
  String name;

  Color color;

  public Car(String name, int r, int g, int b) {
    this.name = name;

    this.color = new Color(r, g, b);
  }

  public Car(String name, String r, String g, String b) {
    this(
      name,
      Integer.parseInt(r),
      Integer.parseInt(g),
      Integer.parseInt(b)
    );
  }

  @Override
  public String toString() {
    return this.name + " #" + Integer.toHexString(color.getRGB() & 0x00FFFFFF);
  }
}
