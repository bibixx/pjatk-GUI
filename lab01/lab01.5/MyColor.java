class MyColor extends java.awt.Color implements Comparable<MyColor> {
  public MyColor(int r, int g, int b) {
    super(r, g, b);
  }

  public int getSum() {
    return this.getRed() + this.getGreen() + this.getBlue();
  }

  public int compareTo(MyColor c) {
    return this.getSum() - c.getSum();
  }

  @Override
  public String toString() {
    return "(" + this.getRed() + ", " + this.getGreen() + ", " + this.getBlue() + ")";
  }
}
