import java.util.ArrayList;
import java.util.Scanner;

public class profits {
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);

    int n;
    while (true) {
      n = stdin.nextInt();
      if (n == 0) break;

      int[] days = new int[n];
      for (int i = 0; i < n; i++) {
        days[i] = stdin.nextInt();
      }

      int res = MCSS(days);
      System.out.println(res);
    }
  }

  static int MCSS(int[] a) {
    int max = 0, accumulator = 0, start = 0, end = 0, i = 0;
    int min = Integer.MIN_VALUE;

    for (int j = 0; j < a.length; j++) {
      if (a[j] > min && a[j] < 0) min = a[j];
      accumulator += a[j];

      if (accumulator > max) {
        max = accumulator;
        start = i;
        end = j;
      } else if (accumulator < 0) {
        i = j + 1;
        accumulator = 0;
      }
    }

    if (start == 0 && end == 0) return min;
    return max;
  }
}
