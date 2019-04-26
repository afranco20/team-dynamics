import java.util.Scanner;

public class sums {
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int n = stdin.nextInt();
    int i, m, j, accumulator;

    for (i = 1; i <= n; i++) {
      m = stdin.nextInt();

      accumulator = 0;
      for (j = 1; j <= m; j++) {
        accumulator += j * triangle_sum(j + 1);
      }

      System.out.printf("%d %d %d%n", i, m, accumulator);
    }
  }

  static int triangle_sum(int n) {
    // int accumulator = 0;
    // for (int i = 1; i <= n; i++) accumulator += i;
    // return accumulator;

    // closed form optimization
    return ((n * (n + 1)) / 2);
  }
}
