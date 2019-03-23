import java.util.Comparator;

class MyColorCompar implements Comparator<MyColor> {
  ColComponent comparatorValue;

  public MyColorCompar(ColComponent comparatorValue) {
    this.comparatorValue = comparatorValue;
  }

  @Override
  public int compare(MyColor c1, MyColor c2) {
    switch (this.comparatorValue) {
      case RED: {
        return c1.getRed() - c2.getRed();
      }
      case GREEN: {
        return c1.getGreen() - c2.getGreen();
      }
      case BLUE: {
        return c1.getBlue() - c2.getBlue();
      }
    }

    throw new Error("No such colour");
  }
}
