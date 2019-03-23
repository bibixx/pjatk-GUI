class Parabola implements FunDD {
  private double a, b, c;

  public Parabola(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public double fun(double x) {
    return this.a * x * x + this.b * x + this.c;
  }
}
