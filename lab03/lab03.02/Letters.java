import java.util.*;

public class Letters implements Iterable<Thread> {
  int i;
  String text;
  ArrayList<Thread> tg;

  public Letters(String text) {
    this.text = text;
    this.tg = new ArrayList<Thread>();

    for (int i = 0; i < text.length(); i++) {
      String letter = Character.toString(text.charAt(i));

      this.tg.add(new Thread(
        () -> {
          try {
            while (true) {
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
    for (Thread t : this.tg) {
      t.stop();
    }
  }

  @Override
  public Iterator<Thread> iterator() {
    return this.tg.iterator();
  }
}
