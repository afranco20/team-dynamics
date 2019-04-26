import java.util.Scanner;

public class paper {
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int n = stdin.nextInt();

    int e, s, p;
    long sum = 0;
    for (int i = 0; i < n; i++) {
      e = stdin.nextInt();

      for (int j = 0; j < e; j++) {
        s = stdin.nextInt();
        p = (int) Math.ceil((stdin.nextDouble()) / 4);
        p = (p > 0) ? p : 1;
        sum += s * p;
      }

      System.out.println(sum);
      sum = 0;
    }
  }
}
