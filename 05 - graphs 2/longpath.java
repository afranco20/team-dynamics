import java.util.Scanner;

public class longpath {
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int c = stdin.nextInt();

    int v, e, s, d, m;
    for (int i = 0; i < c; i++) {
      v = stdin.nextInt();
      e = stdin.nextInt();

      Edge[] edgeList = new Edge[e];
      for (int j = 0; j < e; j++) {
        s = stdin.nextInt();
        d = stdin.nextInt();
        m = stdin.nextInt();

        edgeList[j] = new Edge(s, d, m);
      }

      int min = bellmanFord(edgeList, v, 0);
      for (int k = 0; k < e; k++) edgeList[k].negate();
      int max = bellmanFord(edgeList, v, 0);
      max = max * -1;

      System.out.printf("%d %d%n", min, max);
    }
  }

  static int bellmanFord(Edge[] edgeList, int numVertices, int source) {
    int[] estimates = new int[numVertices];

    for (int i = 0; i < estimates.length; i++) {
      estimates[i] = (int) 1E9;
    }

    estimates[source] = 0;

    for (int i = 0; i < numVertices - 1; i++) {
      for (Edge e : edgeList) {
        if (estimates[e.v1] + e.w < estimates[e.v2]) {
          estimates[e.v2] = estimates[e.v1] + e.w;
        }
      }
    }

    return estimates[numVertices - 1];
  }

  static class Edge {
    final int v1;
    final int v2;
    int w;

    Edge(int v1, int v2, int w) {
      this.v1 = v1;
      this.v2 = v2;
      this.w = w;
    }

    public void negate() {
      this.w = -this.w;
    }
  }
}
