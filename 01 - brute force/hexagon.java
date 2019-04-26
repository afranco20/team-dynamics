import java.util.Arrays;
import java.util.Scanner;

public class hexagon {
  // constants
  private static final int num_pieces = 7;
  private static final int num_sides = 6;

  // shared data
  private static final int[][] hex = new int[num_pieces][num_sides];
  private static boolean found = false;
  private static int case_num;
  private static int p = 0;

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    String input_string;

    int n = Integer.parseInt(stdin.nextLine());
    for (case_num = 1; case_num <= n; case_num++) {
      input_string = stdin.nextLine();
      create_hexagon(input_string.split("\\s"));

      if (p == 5040 && !found) {
        System.out.printf("Case %d: No solution%n", case_num);
      }

      found = false;
      p = 0;
    }
  }

  private static void create_hexagon(String[] input_string) {
    for (int i = 0; i < num_pieces; i++) {
      for (int j = 0; j < num_sides; j++) {
        hex[i][j] = Integer.parseInt(input_string[(i * num_sides) + j]);
      }
    }

    permute(new int[num_pieces], new boolean[num_pieces], 0);
  }

  private static void permute(int[] perm, boolean[] used, int k) {
    if (k == num_pieces) {
      if (check(perm)) {
        found = true;
        System.out.printf("Case %d:", case_num);
        Arrays.stream(perm).forEach(i -> System.out.printf(" %d", i));
        System.out.printf("%n");
      }

      p += 1;
      return;
    }

    for (int i = 0; i < num_pieces; i++) {
      if (!used[i]) {
        used[i] = true;
        perm[k] = i;

        // stuff here
        permute(perm, used, k + 1);
        if (found || p >= 5040) break;

        used[i] = false;
      }
    }
  }

  private static boolean check(int[] order) {
    // rotate center piece
    rotate_hex(order[0], 0, 1);

    // rotate remaining piece
    for (int i = 1; i < num_pieces; i++) {
      rotate_hex(order[i], ((i + 2) % num_sides), hex[order[0]][i - 1]);
    }

    // verify sides
    for (int i = 1; i < num_pieces; i++) {
      int tmp = i + 1;
      if (tmp >= num_pieces) tmp = 1;

      if (hex[order[i]][(i + 1) % num_sides] != hex[order[tmp]][(i + 4) % num_sides]) {
        return false;
      }
    }

    return true;
  }

  // rotates piece so position is equal to number
  private static void rotate_hex(int hex_num, int position, int number) {
    int tmp;

    while (hex[hex_num][position] != number) {
      tmp = hex[hex_num][0];

      System.arraycopy(hex[hex_num], 1, hex[hex_num], 0, num_sides - 1);

      hex[hex_num][num_sides - 1] = tmp;
    }
  }
}
