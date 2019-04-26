import java.util.ArrayDeque;
import java.util.Scanner;

public class monkey {
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int n = Integer.parseInt(stdin.nextLine());

    char tmp[]; int val;
    for (int i = 1; i <= n; i++) {
      tmp = (stdin.nextLine()).toCharArray();

      if (tmp.length == 0) {
        System.out.printf("%d %d%n", i, 1);
      } else {
        val = solve(tmp, 0, tmp.length - 1);
        System.out.printf("%d %d%n", i, val);
      }
    }
  }

  static int solve(char s[], int startIndex, int endIndex) {
    if (startIndex >= endIndex) return 1;

    int left = findIndex(s, startIndex + 1, endIndex);

    int sl = solve(s, startIndex + 1, left);
    int sr = solve(s, left + 1, endIndex - 1);

    return (sl > sr) ? sl * 2 : sr * 2;
  }

  static int findIndex(char s[], int startIndex, int endIndex) {
    ArrayDeque<Character> stack = new ArrayDeque<>();

    stack.addLast(s[startIndex]);
    while ((startIndex + 1) < endIndex && !stack.isEmpty()) {
      if (s[startIndex + 1] == '[') {
        stack.addLast(s[startIndex + 1]);
      } else {
        stack.pollLast();
      }
      startIndex++;
    }

    return startIndex;
  }
}
