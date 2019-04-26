import java.util.ArrayList;
import java.util.Scanner;

public class routes {
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int c = stdin.nextInt();

    int n, m, q, u, v, w, p;
    for (int i = 0; i < c; i++) {
      n = stdin.nextInt();
      m = stdin.nextInt();
      q = stdin.nextInt();

      ArrayList<Edge> edgeList = new ArrayList<>();
      for (int j = 0; j < m; j++) {
        u = stdin.nextInt() - 1;
        v = stdin.nextInt() - 1;
        w = stdin.nextInt();

        edgeList.add(new Edge(u, v, w));
        edgeList.add(new Edge(v, u, w));
      }

      int[] dist = bellmanFord(edgeList.toArray(new Edge[0]), n, 0);

      for (int j = 0; j < q; j++) {
        p = stdin.nextInt();
        System.out.println(dist[p - 1]);
      }
    }
  }

  static int[] bellmanFord(Edge[] edgeList, int numVertices, int source) {
    int[] estimates = new int[numVertices];

    for (int i = 0; i < estimates.length; i++) {
      estimates[i] = (int) 1e9;
    }

    estimates[source] = 0;

    for (int i = 0; i < numVertices - 1; i++) {
      for (Edge e : edgeList) {
        if (estimates[e.v1] + e.w < estimates[e.v2]) {
          estimates[e.v2] = estimates[e.v1] + e.w;
        }
      }
    }

    return estimates;
  }

  static class Edge {
    final int v1;
    final int v2;
    final int w;

    Edge(int v1, int v2, int w) {
      this.v1 = v1;
      this.v2 = v2;
      this.w = w;
    }
  }
}
