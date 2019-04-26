import java.util.ArrayDeque;
import java.util.Scanner;

public class violin1 {
  static ArrayDeque<Integer> dq;

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int n = Integer.parseInt(stdin.nextLine()), k, r, m = 0;

    for (int i = 0; i < n; i++) {
      k = stdin.nextInt();
      dq = new ArrayDeque<>(k);

      for (int j = 0; j < k; j++) {
        r = stdin.nextInt();

        while (dq.peekLast() != null) {
          if (dq.peekLast() <= r) break;

          dq.pollLast();
          m++;
        }

        if (dq.peekLast() == null || r > dq.peekLast()) {
          if (r != 0) {
            dq.addLast(r);
            m++;
          }
        }
      }

      System.out.println(m);
      m = 0;
    }
  }
}
