import java.util.Arrays;
import java.util.Scanner;

public class sameletters {
  static String s1, s2;
  static char tmp[];
  static int c = 1;
  static boolean flag;

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);

    while (true) {
      flag = false;

      s1 = stdin.next();
      if (s1.equals("END")) break;
      s2 = stdin.next();
      tmp = new char[s1.length()];

      if (test()) {
        System.out.printf("Case %d: different%n", c++);
        continue;
      } else {
        System.out.printf("Case %d: same%n", c++);
      }
    }
  }

  static boolean test() {
    char c1[] = s1.toCharArray();
    char c2[] = s2.toCharArray();

    Arrays.sort(c1);
    Arrays.sort(c2);

    if (c1.length != c2.length) {
      return true;
    } else return !Arrays.equals(c1, c2);

  }
}
