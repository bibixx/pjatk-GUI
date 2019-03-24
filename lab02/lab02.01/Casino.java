import java.util.Iterator;
import java.util.NoSuchElementException;

class Casino implements Iterable<Integer> {
  
  @Override
  public Iterator<Integer> iterator() {
    return new Iterator<Integer>() {
      int noInARow = 1;
      int lastNumber = -1;

      @Override
      public boolean hasNext() {
        return noInARow < 3;
      }

      @Override
      public Integer next() {
        if (!this.hasNext()) {
          throw new NoSuchElementException();
        }

        // /*
        int newNumber = (int)Math.round(Math.random());
        /*/
        int newNumber = (int)Math.round(SeededRandom.random());
        //*/
        
        if (lastNumber != newNumber) {
          noInARow = 1;
        } else {
          noInARow++;
        }

        lastNumber = newNumber;

        return lastNumber;
      }
    };
  }
}
