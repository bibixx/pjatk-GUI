public class StrToInt implements Transform<String, Integer> {
  @Override
  public Integer apply(String in) {
    return in.length();
  }
}
