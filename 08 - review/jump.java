import java.util.Scanner;

public class jump {
  static int[] blocks;
  static int u;
  static int d;
  static int count;

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);

    int n = stdin.nextInt();
    for (int i = 0; i < n; i++) {
      count = 0;

      int b = stdin.nextInt();
      blocks = new int[b];

      for (int j = 0; j < b; j++) {
        blocks[j] = stdin.nextInt();
      }

      u = stdin.nextInt();
      d = stdin.nextInt();

      perms(new int[b], new boolean[b], 0);
      System.out.println(count);
    }
  }

  public static void perms(int[] arr, boolean[] used, int k) {
    if (k == blocks.length) {
      if (isValid(arr)) count++;
      return;
    }

    for (int i = 0; i < blocks.length; i++) {
      if (used[i]) continue;

      used[i] = true;
      arr[k] = blocks[i];
      perms(arr, used, k + 1);
      used[i] = false;
    }
  }

  public static boolean isValid(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      int diff = arr[i + 1] - arr[i];

      if (diff > 0) {
        if (diff > u) return false;
      } else {
        diff *= -1;
        if (diff > d) return false;
      }
    }

    return true;
  }
}
