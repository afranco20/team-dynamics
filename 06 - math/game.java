import java.util.Scanner;

public class game {
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int n = Integer.parseInt(stdin.nextLine());

    int res = 0;
    String tmp;
    for (int i = 0; i < n; i++) {
      tmp = stdin.nextLine();
      res = count(tmp.toCharArray());
      System.out.println(res);
    }
  }

  static int count(char[] s) {
    int max = 0, sum = 0;

    for (int i = 0; i < s.length; i++) {
      if (s[i] == 'v') sum++;
      if (s[i] == '^') sum--;

      if (sum > max) {
        max = sum;
      }
    }

    return max;
  }
}
