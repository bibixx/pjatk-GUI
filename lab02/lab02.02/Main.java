public class Main {
  public static void main(String... args) {
    // /*
    int ini = 10, count = -1, maxel = 0;
    /*/
    int ini = 77031, count = -1, maxel = 0;
    //*/

    Hailstone hailstone = new Hailstone(ini);
    for (int h : hailstone) {
      if (h > maxel) maxel = h;
      ++count;
    }

    System.out.println(ini + " " + count + " " + maxel);
    // 10 6 16
  }
}
