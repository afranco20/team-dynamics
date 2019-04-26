import java.util.PriorityQueue;
import java.util.Scanner;

public class sorting {
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int n = stdin.nextInt();

    PriorityQueue<Integer> papers;
    int g, stack = 0, sum = 0;
    for (int i = 0; i < n; i++) {
      g = stdin.nextInt();
      papers = new PriorityQueue<>(g);
      for (int j = 0; j < g; j++) {
        int tmp = stdin.nextInt();
        if (tmp <= 0) continue;
        papers.add(tmp);
      }

      while (papers.size() > 1) {
        stack = papers.poll();
        stack += papers.poll();
        sum += stack;
        papers.offer(stack);
        stack = 0;
      }

      System.out.println(sum);
      sum = 0;
    }
  }
}
