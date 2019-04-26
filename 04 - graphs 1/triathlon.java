import java.util.Arrays;
import java.util.Scanner;

public class triathlon {
  static final double[] len = new double[3];
  static Competitor list[];

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int n = Integer.parseInt(stdin.nextLine());

    for (int i = 1; i <= n; i++) {
      int c = stdin.nextInt();

      for (int j = 0; j < 3; j++) len[j] = stdin.nextDouble();

      list = new Competitor[c];
      for (int j = 0; j < c; j++) {

        String last = stdin.next();
        String first = stdin.next();
        int age = stdin.nextInt();
        double mph[] = new double[3];
        for (int k = 0; k < 3; k++) mph[k] = stdin.nextDouble();

        list[j] = new Competitor(first, last, age, mph);
      }

      Arrays.sort(list);
      System.out.printf("Race %d:%n", i);
      for (Competitor p : list) {
        System.out.printf("%s %s %.3f%n", p.last, p.first, p.val);
      }
      System.out.println();
    }
  }

  static class Competitor implements Comparable<Competitor> {
    final String first;
    final String last;
    final int age;
    final double val;
    final double[] mph;

    Competitor(String first, String last, int age, double mph[]) {
      this.first = first;
      this.last = last;
      this.age = age;
      this.mph = mph;

      double tmp = 0;
      for (int i = 0; i < 3; i++) {
        tmp += len[i] / mph[i];
      }
      val = tmp;
    }

    public int compareTo(Competitor other) {
      if (this.val != other.val) {
        return Double.compare(this.val, other.val);
      } if (this.age != other.age) {
       return Integer.compare(this.age, other.age);
      } else if (!this.last.equals(other.last)) {
        return this.last.compareTo(other.last);
      }

      return this.first.compareTo(other.first);
    }
  }
}
