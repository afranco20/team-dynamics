import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class news {
  static Node[] tree;

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int t = stdin.nextInt();

    for (int i = 0; i < t; i++) {
      int n = stdin.nextInt();

      int[] employees = new int[n];
      for (int j = 1; j < n; j++) {
        employees[j] = stdin.nextInt();
      }

      // create graph
      tree = new Node[n];
      for (int j = 0; j < n; j++) {
        if (j == 0) {
          tree[j] = new Node(j);
        } else {
          tree[j] = new Node(j);
          tree[employees[j]].children.add(tree[j]);
        }
      }

      int res = tree[0].solve();
      System.out.println(res);
    }
  }

  static class Node {
    final int id;
    ArrayList<Node> children;

    Node(int id) {
      this.id = id;
      this.children = new ArrayList<>();
    }

    public int solve() {
      if (children.isEmpty()) return 0;

      Integer[] ans = new Integer[children.size()];

      int c = 0;
      for (Node n : this.children) {
        ans[c++] = n.solve();
      }

      Arrays.sort(ans);
      Arrays.sort(ans, Collections.reverseOrder());

      for (int i = 1; i <= ans.length; i++) {
        ans[i - 1] += i;
      }

      Arrays.sort(ans);
      Arrays.sort(ans, Collections.reverseOrder());

      return ans[0];
    }
  }
}
