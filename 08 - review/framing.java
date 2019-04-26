import java.io.*;
import java.util.*;
import java.lang.Math;

public class framing {
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int t = stdin.nextInt();
    for (int i = 0; i < t; i++) {
      int n = stdin.nextInt();

      System.out.print("Group #" + (i + 1) + ": ");
      double sum = 0;

      for (int j = 0; j < n; j++) {
        int f = stdin.nextInt();
        for (int k = 0; k < f; k++) {
          double l = stdin.nextDouble();
          double w = stdin.nextDouble();
          double d = stdin.nextDouble();

          double a = d / Math.sqrt(2);

          double area1 = l * w;
          double area2 = (l + a + a) * (w + a + a);
          double ans = area2 - area1;
          sum += ans;
        }
      }

      System.out.printf("%.2f cubic inches%n", Math.round(sum * 100.0) / 100.0);
      System.out.println();
    }
  }
}
