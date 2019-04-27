import javax.swing.SwingUtilities;

class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      new Window1();
      new Window2();
      new Window3();
    });
  }
}

