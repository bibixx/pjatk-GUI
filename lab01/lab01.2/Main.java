import java.util.Arrays;

class Main {
  private static String[] filter(String[] arr, SFilter filtr) {
    int c = 0;
    String[] tmpArr = new String[arr.length];

    for (String arrElement : arr) {
      if (filtr.test(arrElement)) {
        tmpArr[c] = arrElement;
        c++;
      }
    }

    String[] outArr = new String[c];
    int len = c;

    for (int i = 0; i < len; i++) {
      String arrElement = tmpArr[i];
      outArr[outArr.length - c--] = arrElement;
    }

    return outArr;
  }

  public static void main (String[] args) {
    String[] arr = {"Alice", "Sue", "Janet", "Bea"};
    System.out.println(Arrays.toString(arr));
    System.out.println();

    LenFilter lenF = new LenFilter(3);

    String[] a1 = filter(arr, lenF);
    System.out.println("#1");
    System.out.println("Got:      " + Arrays.toString(a1));
    System.out.println("Expected: [Alice, Janet]");
    System.out.println();
    
    String[] a2 = filter(arr, new SFilter(){
      @Override
      public boolean test(String s) {
        return s.charAt(0) < 'D';
      }
    });
    
    System.out.println("#2");
    System.out.println("Got:      " + Arrays.toString(a2));
    System.out.println("Expected: [Alice, Bea]");
    System.out.println();
    
    String[] a3 = filter(arr, (String s) -> s.charAt(0) > 'H');
    System.out.println("#3");
    System.out.println("Got:      " + Arrays.toString(a3));
    System.out.println("Expected: [Sue, Janet]");
  }
}
