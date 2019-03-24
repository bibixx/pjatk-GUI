public class Main {
  public static void main(String[] args) {
    for (int turn = 0; turn < 10; ++turn) {
      for (Integer i : new Casino()) {
        System.out.print(i + " ");
      }

      System.out.println();
    }
  }
}
