import java.util.ArrayList;
import java.util.Scanner;

public class fruit {
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int n = Integer.parseInt(stdin.nextLine()), d;
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      d = stdin.nextInt();

      for (int j = 0; j < d; j++) {
        list.add(stdin.nextInt());
      }

      order(list);
      list.clear();
    }
  }

  public static void order(ArrayList<Integer> list) {
    int extra, max;

    l1:
    for (int i = 0; i <= 1000; i++) {
      extra = 0;
      max = 0;

      for (int j = 0, n = list.size(); j <= n; j++) {
        if (j == n) {
          System.out.println(i + " " + max);
          return;
        } else if ((i + extra) >= list.get(j)) {
          extra = (i + extra) - list.get(j);
          if (extra > max) max = extra;
        } else if ((i + extra) < list.get(j)) {
          continue l1;
        }
      }
    }
  }
}
