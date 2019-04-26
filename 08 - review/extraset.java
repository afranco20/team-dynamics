import java.util.HashSet;
import java.util.Scanner;

public class extraset {
  static int k;
  static int n;

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int c = stdin.nextInt();

    int ans;
    HashSet<String> cards;
    StringBuilder card;
    int[][] arr;

    for (int i = 0; i < c; i++) {
      k = stdin.nextInt();
      n = stdin.nextInt();

      ans = 0;
      cards = new HashSet<>();

      arr = new int[n][k];
      for (int x = 0; x < n; x++) {
        card = new StringBuilder();

        for (int y = 0; y < k; y++) {
          arr[x][y] = stdin.nextInt();
          card.append(arr[x][y]);
        }

        cards.add(card.toString());
      }


      boolean[][] used = new boolean[n][n];
      for (int x = 0; x < n; x++) {
        used[x][x] = true;

        for (int y = 0; y < n; y++) {
          if (used[x][y]) continue;

          used[x][y] = true;
          used[y][x] = true;

          String match = generateMatch(arr[x], arr[y]);
          if (cards.contains(match)) {
            ans++;
          }
        }
      }

      System.out.println(ans / 3);
    }
  }

  public static String generateMatch(int[] card1, int[] card2) {
    StringBuilder matchingCard = new StringBuilder();

    int a, b, val;
    for (int i = 0; i < k; i++) {
      a = card1[i];
      b = card2[i];

      if (a == b) {
        matchingCard.append(a);
      } else {
        val = a | b;

        switch (val) {
          case 1:
            matchingCard.append(2);
            break;
          case 2:
            matchingCard.append(1);
            break;
          case 3:
            matchingCard.append(0);
            break;
        }
      }
    }

    return matchingCard.toString();
  }
}
