@FunctionalInterface
interface FunDD {
  double fun(double x);

  static double xminim(FunDD f, double a, double b) {
    double precision = 1e-5;
    double minX = a;
    double minVal = f.fun(a);

    for (double i = a; i < b; i += precision) {
      if (f.fun(i) < minVal) {
        minVal = f.fun(i);
        minX = i;
      }
    }

    return minX;
  }
}
