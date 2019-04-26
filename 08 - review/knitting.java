import java.util.*;
import java.io.*;

public class knitting {
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    while (true) {
      int n = stdin.nextInt(); // # of stitches on first row
      int m = stdin.nextInt(); // # of rows in the project
      int k = stdin.nextInt(); // # of stitches to increment / decrement
      if (n == 0 && m == 0 && k == 0)
        break;

      int sum = n;
      int[] pattern = new int[k];
      for (int i = 0; i < k; i++) {
        pattern[i] = stdin.nextInt();
      }

      int temp = n;
      for (int i = 1; i < m; i++) {
        temp += pattern[(i - 1) % k];
        sum += temp;
      }

      System.out.println(sum);
    }
  }
}
