import java.util.Iterator;

public class Hailstone implements Iterable<Integer> {
  private int lastStepValue;
  private boolean wasInitialised = false;

  public Hailstone(int init) {
    this.lastStepValue = init;
  }

  public Iterator<Integer> iterator() {
    return new Iterator<Integer>() {
      public boolean hasNext() {
        return lastStepValue != 1;
      }
    
      public Integer next() {
        if (!wasInitialised) {
          wasInitialised = true;
          return lastStepValue;
        }

        if (lastStepValue % 2 == 0) {
          lastStepValue = lastStepValue / 2;
        } else {
          lastStepValue = 3 * lastStepValue + 1;
        }

        return lastStepValue;
      }
    };
  }
}
