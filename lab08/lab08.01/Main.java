import javax.swing.JFrame;
import javax.swing.SwingUtilities;

class Main extends JFrame {
  public static void main(String[] argv) {
    SwingUtilities.invokeLater(() -> {
      new Window();
    });
  }
}

