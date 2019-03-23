class Main {
  public static void main(String[] args) {
    Parabola p = new Parabola(1, -1, 5/4);

    System.out.println(FunDD.xminim(p, 0, 1));

    System.out.println(FunDD.xminim(new FunDD(){
      public double fun(double x) {
        return Math.sqrt(Math.pow((x - 0.75), 2) + 1);
      }
    }, 0, 2));

    System.out.println(FunDD.xminim((x) -> x * x * (x-2), 0, 2));
  }
}
