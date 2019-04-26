import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class cables {

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    Edge[] edgeList;
    double min;
    int n;

    while (true) {
      n = stdin.nextInt();
      if (n == 0) break;

      edgeList = createEdgeList(stdin, n);
      min = kruskals(edgeList, n);
      System.out.printf("%.2f%n", min);
    }
  }

  public static Edge[] createEdgeList(Scanner stdin, int n) {
    ArrayList<Edge> edgeList = new ArrayList<>();
    Vertex[] vertices = new Vertex[n];
    int x, y;

    for (int i = 0; i < n; i++) {
      x = stdin.nextInt();
      y = stdin.nextInt();
      vertices[i] = (new Vertex(i, x, y));
    }

    for (int i = 0; i < (n - 1); i++) {
      for (int j = i + 1; j < n; j++) {
        edgeList.add(new Edge(vertices[i], vertices[j]));
      }
    }

    return edgeList.toArray(new Edge[0]);
  }

  public static double kruskals(Edge[] edgeList, int n) {
    djset set = new djset(n);
    int edgeCount = 0, i = 0;
    double mstWeight = 0;

    Arrays.sort(edgeList);
    while (edgeCount < (n - 1) && i < edgeList.length) {
      boolean res = set.union(edgeList[i].v1.i, edgeList[i].v2.i);

      if (res) {
        edgeCount++;
        mstWeight += edgeList[i].dist;
      }

      i++;
    }

    // no mst
    if (edgeCount < n - 1) return -1;
    return mstWeight;
  }

  static class djset {
    public int[] parent;

    public djset(int n) {
      parent = new int[n];
      for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int v) {
      // I am the club president!!! (root of the tree)
      if (parent[v] == v) return v;

      // Find my parent's root.
      int res = find(parent[v]);

      // Attach me directly to the root of my tree.
      parent[v] = res;
      return res;
    }

    public boolean union(int v1, int v2) {
      // Find respective roots.
      int rootv1 = find(v1);
      int rootv2 = find(v2);

      // No union done, v1, v2 already together.
      if (rootv1 == rootv2) return false;

      // Attach tree of v2 to tree of v1.
      parent[rootv2] = rootv1;
      return true;
    }
  }

  static class Edge implements Comparable<Edge> {
    final Vertex v1;
    final Vertex v2;
    double dist;

    Edge(Vertex v1, Vertex v2) {
      this.v1 = v1;
      this.v2 = v2;
      dist(v1, v2);
    }

    void dist(Vertex v1, Vertex v2) {
      int a = v2.x - v1.x;
      int b = v2.y - v1.y;
      this.dist = Math.sqrt((a * a) + (b * b));
    }

    public int compareTo(Edge o) {
      return Double.compare(this.dist, o.dist);
    }
  }

  static class Vertex {
    final int i;
    final int x;
    final int y;

    Vertex(int i, int x, int y) {
      this.i = i;
      this.x = x;
      this.y = y;
    }
  }
}
