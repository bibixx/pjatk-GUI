import java.util.*;

public class Letters implements Iterable<Thread> {
  int i;
  String text;
  ArrayList<Thread> tg;
  Boolean shouldRun;

  public Letters(String text) {
    this.text = text;
    this.tg = new ArrayList<Thread>();
    this.shouldRun = true;

    for (int i = 0; i < text.length(); i++) {
      String letter = Character.toString(text.charAt(i));

      this.tg.add(new Thread(
        () -> {
          try {
            while (this.shouldRun) {
              System.out.print(letter);
              Thread.sleep(1000);
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        },
        letter
      ));
    }
  }

  public void start() {
    for (Thread t : this.tg) {
      t.start();
    }
  }

  public void stop() {
    this.shouldRun = false;
  }

  @Override
  public Iterator<Thread> iterator() {
    return this.tg.iterator();
  }
}
