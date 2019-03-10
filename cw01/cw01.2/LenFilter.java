class LenFilter implements SFilter {
  int minLen;

  public boolean test(String s) {
    return s.length() > minLen;
  }

  public LenFilter(int minLen) {
    this.minLen = minLen;
  }
}
