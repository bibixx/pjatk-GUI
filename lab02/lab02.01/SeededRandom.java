class SeededRandom {
  public static int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0};
  public static int arrI = 0;

  public static int random() {
    return arr[arrI++];
  }
}
