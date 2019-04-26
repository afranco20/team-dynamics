import java.util.Scanner;

public class upwards {
  private static boolean flag = false;

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);

    int n = Integer.parseInt(stdin.nextLine());
    String tmp;
    for (int i = 0; i < n; i++) {
      tmp = stdin.nextLine();

      solve(tmp.toCharArray(), 'a', 0);

      if (flag) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }

      flag = false;
    }
  }

  private static void solve(char[] word, char start, int k) {
    if (k == word.length) {
      flag = true;
    } else {
      for (char i = start; i <= 'z'; i++) {
        if (word[k] < i) {
          return;
        } else if (word[k] == i) {
          solve(word, ++i, k + 1);
          break;
        }
      }
    }
  }
}
