import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class puzzle {
  // directions of movement for swaps.
  static final int[][] dir = {{0, 0, 1, -1}, {1, -1, 0, 0}};

  // lookup table of move count per grid config
  static final HashMap<Integer, Integer> lookup = new HashMap<>(181_440);

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int n = stdin.nextInt();
    int grid[];

    lookup.put(123_456_780, 0);
    solve();

    for (int i = 0; i < n; i++) {
      grid = new int[9];

      for (int j = 0; j < 9; j++) {
        grid[j] = stdin.nextInt();
      }

      System.out.println(lookup.get(shrinkGrid(grid)));
    }
  }

  // BFS
  static void solve() {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    ArrayDeque<Integer> moves;
    int gridVal, count;

    q.addLast(123_456_780);
    while (!q.isEmpty()) {
      gridVal = q.pollFirst();
      count = lookup.get(gridVal);

      moves = generateMoves(gridVal);
      for (int m : moves) {
        if (!lookup.containsKey(m)) {
          lookup.put(m, count + 1);
          q.addLast(m);
        }
      }
    }
  }

  static ArrayDeque<Integer> generateMoves(int gridVal) {
    ArrayDeque<Integer> moves = new ArrayDeque<>();
    int grid[] = expandGrid(gridVal);
    int index = 0, x1, y1, x2, y2;

    while (grid[index] != 0) index++;

    x1 = index / 3;
    y1 = index % 3;

    for (int i = 0; i < dir[0].length; i++) {
      x2 = x1 + dir[0][i];
      y2 = y1 + dir[1][i];
      if (x2 >= 3 || x2 < 0 || y2 >= 3 || y2 < 0) continue;

      swapToken(grid, x1, y1, x2, y2); // swap tokenVal and 0
      moves.addLast(shrinkGrid(grid)); // add to moves list
      swapToken(grid, x1, y1, x2, y2); // undo swap
    }

    return moves;
  }

  static void swapToken(int grid[], int x1, int y1, int x2, int y2) {
    int tmp = grid[(3 * x1) + y1];
    grid[(3 * x1) + y1] = grid[(3 * x2) + y2];
    grid[(3 * x2) + y2] = tmp;
  }

  // horner's method
  static int shrinkGrid(int grid[]) {
    int sum = 0;
    for (int i = 0; i < 9; i++) {
      sum = grid[i] + (10 * sum);
    }

    return sum;
  }

  static int[] expandGrid(int gridVal) {
    int grid[] = new int[9];
    for (int i = 8; i >= 0; i--) {
      grid[i] = gridVal % 10;
      gridVal /= 10;
    }

    return grid;
  }
}
