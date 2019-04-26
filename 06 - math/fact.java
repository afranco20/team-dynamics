import java.util.BitSet;
import java.util.Scanner;

public class fact {
  static BitSet isPrime;

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int n = stdin.nextInt();
    int t, res;

    for (int i = 0; i < n; i++) {
      t = stdin.nextInt();

      isPrime = new BitSet(t);
      primeSieve(t);

      for (int j = 2; j <= t; j = isPrime.nextClearBit(j + 1)) {
        res = numTimesDivide(t, j);
        System.out.print(res + " ");
      }

      System.out.println();
    }
  }

  static void primeSieve(int n) {
    isPrime.set(1, 2);

    int sqrt_n = (int) Math.sqrt(n) + 1;
    for (int i = 2; i <= sqrt_n; i = isPrime.nextClearBit(i + 1)) {
      for (int j = i * i; j <= n; j += i) {
        isPrime.set(j);
      }
    }
  }

  static int numTimesDivide(int n, int p) {
    int res = 0;
    while (n > 0) {
      res += (n / p);
      n /= p;
    }
    return res;
  }
}
