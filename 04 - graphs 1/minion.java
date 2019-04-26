import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

public class minion {
  static HashSet<String> trials;
  static boolean g1[][];
  static String g2[][];
  static int n, e;

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int m = stdin.nextInt();
    for (int i = 0; i < m; i++) {
      int t = stdin.nextInt();
      trials = new HashSet<>(t);

      for (int j = 0; j < t; j++) {
        trials.add(stdin.next());
      }

      n = stdin.nextInt();
      g1 = new boolean[n][n];
      g2 = new String[n][n];
      e = stdin.nextInt();

      String q;
      int la, lb;
      for (int j = 0; j < e; j++) {
        la = stdin.nextInt();
        lb = stdin.nextInt();
        q = stdin.next();

        g1[la][lb] = g1[lb][la] = true;
        g2[la][lb] = g2[lb][la] = q;
      }

      boolean visited[] = new boolean[n];
      BFS(0, visited);
      if (visited[n - 1]) System.out.println(1);
      else System.out.println(0);
    }
  }

  static void BFS(int start, boolean[] visited) {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    q.addLast(start);
    visited[start] = true;

    int at;
    while (!q.isEmpty()) {
      at = q.pollFirst();

      for (int i = 0; i < n; i++) {
        if (g1[at][i] && !visited[i] && !trials.contains(g2[at][i])) {
          q.addLast(i);
          visited[i] = true;
        }
      }
    }
  }
}
