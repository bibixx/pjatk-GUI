import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultListModel;

class RandomDate implements Runnable {
  private Thread t;
  private String threadName;
  private DefaultListModel<String> model;
  private boolean sleep;

  RandomDate(String name, DefaultListModel<String> model) {
    threadName = name;
    System.out.println("Creating " +  threadName );
    this.model = model;
    this.sleep = false;
  }

  public void run() {
    while(true) {
      try {
        if (!this.sleep) {
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
          LocalDateTime now = LocalDateTime.now();
          String nowFormatted = dtf.format(now);

          model.addElement(nowFormatted);

          System.out.println("Thread: " + threadName + ", " + nowFormatted);
          Thread.sleep((long)Math.floor(Math.random() * 1000 + 500));
        }
      } catch (InterruptedException e) {
        System.out.println("Thread " +  threadName + " interrupted.");
      }
    }
  }

  public void toggle() {
    System.out.println(1);
    this.sleep = !this.sleep;
  }

  public void start () {
     System.out.println("Starting " +  threadName );
     if (t == null) {
        t = new Thread(this, threadName);
        t.start();
     }
  }
}
