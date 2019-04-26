import java.util.Scanner;

public class passwords {
  static String s[] = null;
  static int m = 0, r = 0, z = 0;
  static boolean flag = false;

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);

    char pass[];

    int c = Integer.parseInt(stdin.nextLine());
    for (int i = 0; i < c; i++) {
      m = Integer.parseInt(stdin.nextLine());
      s = new String[m];
      pass = new char[m];

      for (int j = 0; j < m; j++) {
        s[j] = stdin.nextLine();
      }

      r = Integer.parseInt(stdin.nextLine()) - 1;
      generate(pass, 0);
      z = 0;
      flag = false;
    }
  }

  private static void generate(char[] pass, int k) {
    if (k == m) {
      if (z == r) {
        System.out.println(pass);
        flag = true;
      }

      z++;
      return;
    }

    char tmp[] = s[k].toCharArray();
    boolean used[] = new boolean[tmp.length];

    for (int i = 0; i < tmp.length; i++) {
      if (flag) {
        break;
      } else if (!used[i]) {
        used[i] = true;
        pass[k] = tmp[i];
        generate(pass, k + 1);
        used[i] = false;
      }
    }
  }
}
