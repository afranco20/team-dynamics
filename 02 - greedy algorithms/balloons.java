import java.util.Arrays;
import java.util.Scanner;

public class balloons {
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int n, a, b, i, sum;
    int k, da, db;
    Team team[];

    while (true) {
      sum = 0;
      n = stdin.nextInt();

      // break b/c 1 <= n <= 1_000
      if (n == 0) break;

      a = stdin.nextInt();
      b = stdin.nextInt();

      team = new Team[n];

      for (i = 0; i < n; i++) {
        k = stdin.nextInt();
        da = stdin.nextInt();
        db = stdin.nextInt();

        team[i] = new Team(k, da, db);
      }

      Arrays.sort(team);

      for (i = 0; i < n; i++) {
        if (team[i].flag) {
          if (a >= team[i].k) {
            sum += team[i].k * team[i].da;
            a -= team[i].k;
          } else {
            sum += a * team[i].da;
            team[i].k -= a;
            a = 0;

            sum += team[i].k * team[i].db;
            b -= team[i].k;
          }
        } else {
          if (b >= team[i].k) {
            sum += team[i].k * team[i].db;
            b -= team[i].k;
          } else {
            sum += b * team[i].db;
            team[i].k -= b;
            b = 0;

            sum += team[i].k * team[i].da;
            a -= team[i].k;
          }
        }
      }

      System.out.println(sum);
    }
  }

  static class Team implements Comparable<Team> {
    final int da;
    final int db;
    final int diff;
    final boolean flag;
    int k;

    public Team(int k, int da, int db) {
      this.k = k;
      this.da = da;
      this.db = db;
      this.flag = this.da < this.db;
      this.diff = Math.abs(this.da - this.db);
    }

    public int compareTo(Team other) {
      return Integer.compare(other.diff, this.diff);
    }
  }
}
