@FunctionalInterface
public interface Transform<T, R> {
  public R apply(T in);
}
