import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class Main {
  public static void main(String[] argv) {
    Node head = null;
  
    // /*
    String filename = "ok.js";
    /*/
    String filename = "notok.js";
    //*/
    int currentCharIndex = 0;
    boolean isValid = true;
    
    try {
      FileInputStream fis = new FileInputStream(new File(filename));

      while (fis.available() > 0) {
        char currentChar = (char) fis.read();
        currentCharIndex++;

        if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
          head = new Node(currentChar, head);
        } else if (currentChar == ')' || currentChar == '}' || currentChar == ']') {
          if (
            head == null ||  
            getMatching(currentChar) != head.bracketType
          ) {
            isValid = false;
            break;
          }

          head = head.next;
        }
      }

      if (head != null) {
        isValid = false;
      }

      fis.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (isValid) {
      System.out.println("OK!");
    } else {
      throw new Error("Invalid char at position " + currentCharIndex);
    }
  }

  public static char getMatching(char bracketType) {
    switch (bracketType) {
      case ')': return '(';
      case '}': return '{';
      case ']': return '[';
    }

    throw new Error("No matching bracket found");
  }
}
