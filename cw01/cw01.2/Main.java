import java.util.ArrayList;
import java.util.Arrays;

class Main {
  private static String[] filter(String[] arr, SFilter filtr) {
    int c = 0;
    ArrayList<String> tmpArr = new ArrayList<String>();

    for (String arrElement : arr) {
      if (filtr.test(arrElement)) {
        tmpArr.add(arrElement);
        c++;
      }
    }

    String[] outArr = new String[c];

    for (String arrElement : tmpArr) {
      outArr[outArr.length - c--] = arrElement;
    }

    return outArr;
  }

  public static void main (String[] args) {
    String[] arr = {"Alice", "Sue", "Janet", "Bea"};
    System.out.println(Arrays.toString(arr));
    LenFilter lenF = new LenFilter(3);

    String[] a1 = filter(arr, lenF);
    System.out.println(Arrays.toString(a1));

    String[] a2 = filter(arr, new SFilter(){
      @Override
      public boolean test(String s) {
        return s.charAt(0) < 'D';
      }
    });

    System.out.println(Arrays.toString(a2));

    String[] a3 = filter(arr, (String s) -> s.charAt(0) > 'H');
    System.out.println(Arrays.toString(a3));
  }
}
