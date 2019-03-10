import java.util.Arrays;

class Main {
  private static <T, R> void transform(T[] in, R[] out, Transform<T, R> trans) {
    int length = in.length;
    for (int i = 0; i < length; i++) {
      out[i] = trans.apply(in[i]);
    }
  }

  public static void main(String[] args) {
    String[]  sin = {"Alice", "Sue", "Janet", "Bea"};
    System.out.println(Arrays.toString(sin) + '\n');

    Integer[] iout = new Integer[sin.length];
    transform(sin, iout, new StrToInt());
    System.out.println("#1");
    System.out.println("Got:      " + Arrays.toString(iout));
    System.out.println("Exepcted: [5, 3, 5, 3]");
    System.out.println("");

    Character[] cout = new Character[sin.length];
    transform(sin, cout, new Transform<String, Character>(){
      @Override
      public Character apply(String in) {
        return in.charAt(0);
      }
    });
    System.out.println("#2");
    System.out.println("Got:      " + Arrays.toString(cout));
    System.out.println("Exepcted: [A, S, J, B]");
    System.out.println("");
    
    String[] sout = new String[sin.length];
    transform(sin, sout, (String s) -> s.toUpperCase());

    System.out.println("#3");
    System.out.println("Got:      " + Arrays.toString(sout));
    System.out.println("Exepcted: [ALICE, SUE, JANET, BEA]");
  }
}

// [Alice, Sue, Janet, Bea]
// [5, 3, 5, 3]
// [A, S, J, B]
// [ALICE, SUE, JANET, BEA]
